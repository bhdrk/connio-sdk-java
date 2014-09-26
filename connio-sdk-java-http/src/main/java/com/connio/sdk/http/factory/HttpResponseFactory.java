package com.connio.sdk.http.factory;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.ConnioResponse;
import com.connio.sdk.http.utils.IOUtils;
import com.connio.sdk.http.utils.json.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 17.09.2014
 */
public class HttpResponseFactory {

    private static HttpResponseFactory instance = new HttpResponseFactory();

    private HttpResponseFactory() {
    }

    public static <RS extends ConnioResponse> RS create(HttpResponse httpResponse, Class<RS> responseType) throws IOException {
        return instance.doCreate(httpResponse, responseType);
    }

    private <RS extends ConnioResponse> RS doCreate(HttpResponse httpResponse, Class<RS> responseType) throws IOException {
        if (isSuccessfulResponse(httpResponse)) {
            RS connioResponse = createConnioResponse(responseType);
            setResult(connioResponse, httpResponse);
            return connioResponse;
        }

        throw createException(httpResponse);
    }

    private ConnioServiceException createException(HttpResponse httpResponse) throws IOException {
        InputStream contentStream = getContentStream(httpResponse);
        String errorContent = contentStream != null ? IOUtils.toString(contentStream) : "";

        ConnioServiceException exception = null;

        if (isNotEmpty(errorContent)) {
            exception = createExceptionIfJsonResponse(httpResponse, errorContent);
        }

        if (exception == null) {
            exception = new ConnioServiceException("error", errorContent, errorContent, null, httpResponse.getStatusLine().toString());
        }

        return exception;
    }

    private ConnioServiceException createExceptionIfJsonResponse(HttpResponse httpResponse, String errorContent) throws IOException {
        JsonNode node = JSON.toNodeTree(errorContent, true);
        if (isErrorJsonResponse(node)) {
            String status = node.get("status").asText();
            String cause = node.get("cause").asText();
            String responseStatus = httpResponse.getStatusLine().toString();
            List<String> details = getDetailsFromNode(node);
            String message = cause + (isNotEmpty(details) ? details : "");
            return new ConnioServiceException(status, message, cause, details, responseStatus);
        }
        return null;
    }

    private boolean isErrorJsonResponse(JsonNode node) {
        return node != null && node.has("status") && "error".equalsIgnoreCase(node.get("status").asText());
    }

    private List<String> getDetailsFromNode(JsonNode node) {
        List<String> details = new ArrayList<String>();
        if (node.has("details")) {
            JsonNode detailsNode = node.get("details");
            if (detailsNode.isArray()) {
                Iterator<JsonNode> elements = detailsNode.elements();
                if (elements != null) {
                    while (elements.hasNext()) {
                        details.add(elements.next().asText());
                    }
                }
            } else {
                details.add(detailsNode.asText());
            }
        }
        return details;
    }

    @SuppressWarnings("unchecked")
    private void setResult(ConnioResponse connioResponse, HttpResponse httpResponse) throws IOException {
        InputStream contentStream = getContentStream(httpResponse);
        if (contentStream != null) {
            Class resultType = connioResponse.getResultType();
            Object result = JSON.fromStream(contentStream, resultType);
            connioResponse.setResult(result);
        }
    }

    private InputStream getContentStream(HttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        if (entity != null && entity.getContent() != null) {
            return entity.getContent();
        } else {
            return null;
        }
    }

    private <RS extends ConnioResponse> RS createConnioResponse(Class<RS> responseType) {
        try {
            return responseType.newInstance();
        } catch (Exception e) {
            throw new ConnioClientException(e);
        }
    }

    private boolean isSuccessfulResponse(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        return (statusCode / 100) == (HttpStatus.SC_OK / 100);
    }
}

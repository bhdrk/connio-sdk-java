package com.connio.sdk.http.internal;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.ConnioResponse;
import com.connio.sdk.http.converter.ConverterChain;
import com.connio.sdk.http.json.JSON;
import com.connio.sdk.http.utils.HttpUtils;
import com.connio.sdk.http.utils.IOUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

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
 * @since 02.10.2014
 */
public class ResponseFactory {
    private static final ResponseFactory instance = new ResponseFactory();

    private ResponseFactory() {
    }

    public static <RS extends ConnioResponse> RS create(Response response, Class<RS> responseType) throws IOException {
        return instance.doCreate(response, responseType);
    }

    @SuppressWarnings("unchecked")
    private <RS extends ConnioResponse> RS doCreate(Response response, Class<RS> responseType) throws IOException {
        if (response.isSuccessful()) {
            RS connioResponse = createConnioResponse(responseType);
            setResult(connioResponse, response, responseType);
            return connioResponse;
        }
        throw createException(response);
    }

    private ConnioServiceException createException(Response response) throws IOException {
        InputStream is = response.body().byteStream();
        String errorContent = is != null ? IOUtils.toString(is) : "";

        ConnioServiceException exception = null;

        if (isNotEmpty(errorContent)) {
            exception = createExceptionIfJsonResponse(response, errorContent);
        }

        if (exception == null) {
            exception = new ConnioServiceException("error", errorContent, null, response.message(), response.code());
        }

        return exception;
    }

    private <RT, RS extends ConnioResponse<RT>> void setResult(RS connioResponse, Response response, Class<RS> responseType) throws IOException {
        ResponseBody body = response.body();
        InputStream is = body.byteStream();
        if (is != null) {
            Class<RT> resultType = HttpUtils.resolveResultType(connioResponse);
            RT result = ConverterChain.instance().to(body.contentType().toString(), is, resultType);
            connioResponse.setResult(result);
        }
    }

    private <RS extends ConnioResponse> RS createConnioResponse(Class<RS> responseType) {
        try {
            return responseType.newInstance();
        } catch (Exception e) {
            throw new ConnioClientException(e);
        }
    }

    private ConnioServiceException createExceptionIfJsonResponse(Response response, String errorContent) throws IOException {
        JsonNode node = JSON.toNodeTree(errorContent, true);
        if (isServerErrorResponse(node)) {
            String status = node.get("status").asText();
            String cause = node.get("cause").asText();
            List<String> details = getDetailsFromNode(node);
            return new ConnioServiceException(status, cause, details, response.message(), response.code());
        }
        return null;
    }

    private boolean isServerErrorResponse(JsonNode node) {
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
}

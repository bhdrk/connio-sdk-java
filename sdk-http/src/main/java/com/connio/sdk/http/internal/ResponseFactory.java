package com.connio.sdk.http.internal;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioResourceNotFoundException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.ConnioResponse;
import com.connio.sdk.http.json.JSON;
import com.connio.sdk.http.utils.HttpUtils;
import com.connio.sdk.http.utils.IOUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
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

    private static final Logger LOG = LoggerFactory.getLogger(ResponseFactory.class);

    public ResponseFactory() {
    }

    @SuppressWarnings("unchecked")
    public <RS extends ConnioResponse> RS create(Response response, Class<RS> responseType) {
        logResponse(response);

        if (response.isSuccessful()) {
            RS connioResponse = createConnioResponse(responseType);
            setResult(connioResponse, response, responseType);
            return connioResponse;
        }
        throw createException(response);
    }


    private ConnioServiceException createException(Response response) {
        String errorContent = getResponseContent(response);

        if (LOG.isTraceEnabled()) {
            LOG.trace("Response Error Body: " + errorContent);
        }

        ConnioServiceException exception = null;

        if (isNotEmpty(errorContent)) {
            exception = createExceptionIfJsonResponse(response, errorContent);
        }

        if (exception == null) {
            exception = new ConnioServiceException("error", errorContent, null, response.message(), response.code());
        }

        if (response.code() == 404) {
            exception = new ConnioResourceNotFoundException(
                    exception.getStatus(),
                    exception.getCauseMessage(),
                    exception.getDetails(),
                    exception.getResponseStatus(),
                    exception.getResponseCode()
            );
        }

        return exception;
    }

    private String getResponseContent(Response response) {
        InputStream is = response.body().byteStream();
        String errorContent;
        try {
            errorContent = is != null ? IOUtils.toString(is) : "";
        } catch (IOException e) {
            throw new ConnioClientException(e);
        }
        return errorContent;
    }

    private <RT, RS extends ConnioResponse<RT>> void setResult(RS connioResponse, Response response, Class<RS> responseType) {
        ResponseBody body = response.body();
        if (body != null) {
            Class<RT> resultType = HttpUtils.resolveResultType(connioResponse);
            InputStream is = body.byteStream();

            try {
                is = logResponseResult(body, is, responseType, resultType);
                RT result = InternalContext.converterChain().to(body.contentType().toString(), is, resultType);
                connioResponse.setResult(result);
            } finally {
                IOUtils.closeSilently(is);
            }
        }
    }

    private <RS extends ConnioResponse> RS createConnioResponse(Class<RS> responseType) {
        try {
            return responseType.newInstance();
        } catch (Exception e) {
            throw new ConnioClientException(e);
        }
    }

    private ConnioServiceException createExceptionIfJsonResponse(Response response, String errorContent) {
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

    private void logResponse(Response response) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Response Status: " + response.code() + " " + response.message());

            Headers headers = response.headers();
            for (String name : headers.names()) {
                for (String value : headers.values(name)) {
                    LOG.debug("Response Header: " + name + " -> " + value);
                }
            }
        }
    }

    private InputStream logResponseResult(ResponseBody body, InputStream is, Class<?> responseType, Class<?> resultType) {

        if (LOG.isDebugEnabled()) {
            LOG.debug("Response Type: " + responseType.getName());
            LOG.debug("Response Result Type: " + resultType.getName());
        }

        if (LOG.isTraceEnabled() && is != null) {
            LOG.trace("Response Content-Type: " + body.contentType());
            try {
                // copy response body
                byte[] bytes = IOUtils.toByteArray(is);
                LOG.trace("Response Body: " + new String(bytes, getResponseCharset(body)));
                return new ByteArrayInputStream(bytes);
            } catch (IOException e) {
                LOG.error("An error occurred when trying to log response body.", e);
            }
        }

        return is;
    }

    private Charset getResponseCharset(ResponseBody body) {
        MediaType contentType = body.contentType();
        return contentType.charset() != null ? contentType.charset() : Charset.forName("UTF-8");
    }
}

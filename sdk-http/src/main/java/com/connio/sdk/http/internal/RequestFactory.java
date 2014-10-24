package com.connio.sdk.http.internal;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.Method;
import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.TypeUtils;
import com.connio.sdk.http.utils.HttpUtils;
import com.squareup.okhttp.*;
import okio.Buffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class RequestFactory {

    private static final Logger LOG = LoggerFactory.getLogger(RequestFactory.class);

    public RequestFactory() {
    }

    public Request create(ClientConfig clientConfig, ConnioRequest request, ConnioCredentials credentials) {
        RequestMetaData metaData = getMetaData(request);

        URL url = HttpUtils.buildURL(clientConfig, metaData);
        String method = getMethod(metaData);
        RequestBody body = getBody(metaData);
        Headers headers = getHeaders(metaData, credentials);

        logRequest(request, url, method, body, headers);

        return new Request.Builder()
                .url(url)
                .method(method, body)
                .headers(headers)
                .build();
    }

    private void logRequest(ConnioRequest request, URL url, String method, RequestBody body, Headers headers) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request Type: " + request.getClass().getName());
            LOG.debug("Request URL: " + method + " " + url.toString());

            for (String name : headers.names()) {
                for (String value : headers.values(name)) {
                    LOG.debug("Request Header: " + name + " -> " + value);
                }
            }
        }

        if (LOG.isTraceEnabled() && body != null) {
            LOG.trace("Request Content-Type: " + body.contentType());
            try {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                String content = buffer.readString(body.contentType().charset());
                LOG.trace("Request Body: " + content);
            } catch (IOException e) {
                LOG.error("An error occurred when trying to log request body.", e);
            }
        }
    }

    protected String getMethod(RequestMetaData metaData) {
        return metaData.getMethod().name();
    }

    protected Headers getHeaders(RequestMetaData metaData, ConnioCredentials credentials) {
        Headers.Builder builder = new Headers.Builder();
        Map<String, String> headers = metaData.getHeaders();

        if (TypeUtils.isNotEmpty(headers)) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }

        builder.set("Content-Type", metaData.getContentType().toString());
        builder.set("User-Agent", InternalContext.userAgentInfo().getUserAgent());
        builder.set("Authorization", Credentials.basic(credentials.getAccessKey(), credentials.getSecretKey()));

        return builder.build();
    }

    protected RequestBody getBody(RequestMetaData metaData) {
        RequestBody requestBody = null;
        MediaType mediaType = MediaType.parse(metaData.getContentType().toString());
        if (metaData.getRequestContent() != null) {
            String content = InternalContext.converterChain().from(metaData.getContentType().getType(), metaData.getRequestContent());
            requestBody = RequestBody.create(mediaType, content);
        } else if (Method.DELETE.equals(metaData.getMethod())) {
            // required empty body for DELETE method
            requestBody = RequestBody.create(mediaType, "");
        }
        return requestBody;
    }

    protected RequestMetaData getMetaData(ConnioRequest request) {
        RequestMetaData metaData = new RequestMetaData();
        request.loadMetaData(metaData);
        metaData.validate();
        return metaData;
    }
}

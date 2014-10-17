package com.connio.sdk.http.internal;

import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.Method;
import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.TypeUtils;
import com.connio.sdk.http.converter.ConverterChain;
import com.connio.sdk.http.utils.HttpUtils;
import com.connio.sdk.http.utils.UserAgentInfo;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.net.URL;
import java.util.Map;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class RequestFactory {

    private static final RequestFactory factory = new RequestFactory();

    private RequestFactory() {
    }

    public static Request create(ClientConfig clientConfig, ConnioRequest request) {
        return factory.doCreate(clientConfig, request);
    }

    private Request doCreate(ClientConfig clientConfig, ConnioRequest request) {
        RequestMetaData metaData = getMetaData(request);
        URL url = HttpUtils.buildURL(clientConfig, metaData);

        return new Request.Builder()
                .url(url)
                .method(getMethod(metaData), getBody(metaData))
                .headers(getHeaders(metaData))
                .build();
    }

    protected String getMethod(RequestMetaData metaData) {
        return metaData.getMethod().name();
    }

    protected Headers getHeaders(RequestMetaData metaData) {
        Headers.Builder builder = new Headers.Builder();
        Map<String, String> headers = metaData.getHeaders();

        if (TypeUtils.isNotEmpty(headers)) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }

        builder.set("Content-Type", metaData.getContentType().toString());
        builder.set("User-Agent", UserAgentInfo.getUserAgent());

        return builder.build();
    }

    protected RequestBody getBody(RequestMetaData metaData) {
        RequestBody requestBody = null;
        MediaType mediaType = MediaType.parse(metaData.getContentType().toString());
        if (metaData.getRequestContent() != null) {
            String content = ConverterChain.instance().from(metaData.getContentType().getType(), metaData.getRequestContent());
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

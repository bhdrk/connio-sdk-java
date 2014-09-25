package com.connio.sdk.http.factory;

import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.TypeUtils;
import com.connio.sdk.http.model.ClientConfig;
import com.connio.sdk.http.utils.HttpUtils;
import com.connio.sdk.http.utils.UserAgentInfo;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpRequestBase;

import java.net.URI;
import java.util.Map;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class HttpRequestFactory {

    private static HttpRequestFactory factory = new HttpRequestFactory();

    private HttpRequestFactory() {
    }

    public static HttpRequestBase create(ClientConfig clientConfig, ConnioRequest request) {
        return factory.doCreate(clientConfig, request);
    }

    private HttpRequestBase doCreate(ClientConfig clientConfig, ConnioRequest request) {
        RequestMetaData metaData = createRequestMetaData(request);
        HttpRequestBase httpRequest = createHttpMethod(clientConfig, request, metaData);
        addHeaders(httpRequest, metaData);
        return httpRequest;
    }

    private HttpRequestBase createHttpMethod(ClientConfig clientConfig, ConnioRequest request, RequestMetaData metaData) {
        URI uri = HttpUtils.buildURI(clientConfig, metaData);
        return HttpMethodFactory.create(request, metaData, uri);
    }

    private RequestMetaData createRequestMetaData(ConnioRequest request) {
        RequestMetaData metaData = new RequestMetaData();
        request.loadMetaData(metaData);
        return metaData;
    }

    private void addHeaders(HttpRequestBase httpRequest, RequestMetaData metaData) {
        Map<String, String> headers = metaData.getHeaders();
        if (TypeUtils.isNotEmpty(headers)) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                String key = entry.getKey();
                if (isIgnoredHeader(key)) {
                    continue;
                }
                httpRequest.addHeader(key, entry.getValue());
            }
        }
        httpRequest.addHeader(HttpHeaders.CONTENT_TYPE, metaData.getContentType());
        httpRequest.addHeader(HttpHeaders.USER_AGENT, UserAgentInfo.getUserAgent());
    }

    private boolean isIgnoredHeader(String name) {
        return name.equalsIgnoreCase(HttpHeaders.CONTENT_TYPE) ||
                name.equalsIgnoreCase(HttpHeaders.USER_AGENT) ||
                name.equalsIgnoreCase(HttpHeaders.CONTENT_LENGTH) ||
                name.equalsIgnoreCase(HttpHeaders.HOST);
    }
}

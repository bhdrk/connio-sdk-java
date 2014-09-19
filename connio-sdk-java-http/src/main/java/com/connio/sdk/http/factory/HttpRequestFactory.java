package com.connio.sdk.http.factory;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.Method;
import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.TypeUtils;
import com.connio.sdk.http.model.ClientConfig;
import com.connio.sdk.http.utils.HttpUtils;
import com.connio.sdk.http.utils.UserAgentInfo;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class HttpRequestFactory {

    private static HttpRequestFactory factory = new HttpRequestFactory();

    private Map<Method, RequestHandler> requestHandlers;

    private HttpRequestFactory() {
        requestHandlers = new HashMap<Method, RequestHandler>();
        requestHandlers.put(Method.GET, new RequestHandler() {
            @Override
            public HttpRequestBase create(ConnioRequest connioRequest, RequestMetaData metaData, URI uri) {
                HttpRequestBase httpRequest;
                httpRequest = new HttpGet(uri);
                return httpRequest;
            }
        });
        requestHandlers.put(Method.POST, new RequestHandler() {
            @Override
            public HttpRequestBase create(ConnioRequest connioRequest, RequestMetaData metaData, URI uri) {
                HttpRequestBase httpRequest;
                HttpPost httpPost = new HttpPost(uri);
                httpPost.setEntity(HttpEntityFactory.create(connioRequest, metaData));
                httpRequest = httpPost;
                return httpRequest;
            }
        });
        requestHandlers.put(Method.PUT, new RequestHandler() {
            @Override
            public HttpRequestBase create(ConnioRequest connioRequest, RequestMetaData metaData, URI uri) {
                HttpRequestBase httpRequest;
                HttpPut httpPut = new HttpPut(uri);
                httpPut.setEntity(HttpEntityFactory.create(connioRequest, metaData));
                httpRequest = httpPut;
                return httpRequest;
            }
        });
        requestHandlers.put(Method.DELETE, new RequestHandler() {
            @Override
            public HttpRequestBase create(ConnioRequest connioRequest, RequestMetaData metaData, URI uri) {
                HttpRequestBase httpRequest;
                httpRequest = new HttpDelete(uri);
                return httpRequest;
            }
        });

    }

    public static HttpRequestBase create(ClientConfig clientConfig, ConnioRequest request) {
        return factory.doCreate(clientConfig, request);
    }

    private HttpRequestBase doCreate(ClientConfig clientConfig, ConnioRequest request) {
        RequestMetaData metaData = createRequestMetaData(request);
        HttpRequestBase httpRequest = createHttpRequest(clientConfig, request, metaData);
        addHeaders(httpRequest, metaData);
        return httpRequest;
    }

    private HttpRequestBase createHttpRequest(ClientConfig clientConfig, ConnioRequest request, RequestMetaData metaData) {
        HttpRequestBase httpRequest;
        Method method = metaData.getMethod();
        URI uri = HttpUtils.buildURI(clientConfig, metaData);

        if (requestHandlers.containsKey(method)) {
            RequestHandler requestHandler = requestHandlers.get(method);
            httpRequest = requestHandler.create(request, metaData, uri);
        } else {
            throw new ConnioClientException("Unsupported HTTP method: " + method);
        }
        return httpRequest;
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

    private static interface RequestHandler {
        public HttpRequestBase create(ConnioRequest connioRequest, RequestMetaData metaData, URI uri);
    }
}

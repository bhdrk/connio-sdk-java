package com.connio.sdk.http.factory;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.Method;
import com.connio.sdk.api.model.RequestMetaData;
import org.apache.http.client.methods.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public class HttpMethodFactory {

    private static final com.connio.sdk.http.factory.HttpMethodFactory instance = new com.connio.sdk.http.factory.HttpMethodFactory();

    public static HttpRequestBase create(ConnioRequest connioRequest, RequestMetaData metaData, URI uri) {
        return instance.doCreate(connioRequest, metaData, uri);
    }

    private HttpRequestBase doCreate(ConnioRequest connioRequest, RequestMetaData metaData, URI uri) {
        Method method = metaData.getMethod();
        HttpMethodFactoryInternal internalFactory = instance.requestHandlers.get(method);
        if (internalFactory == null) {
            throw new ConnioClientException("Unsupported HTTP method: " + method);
        }
        return internalFactory.create(connioRequest, metaData, uri);
    }

    private Map<Method, HttpMethodFactoryInternal> requestHandlers;

    private HttpMethodFactory() {
        requestHandlers = new HashMap<Method, HttpMethodFactoryInternal>();
        requestHandlers.put(Method.GET, new HttpMethodFactoryInternal() {
            @Override
            public HttpRequestBase create(ConnioRequest connioRequest, RequestMetaData metaData, URI uri) {
                HttpRequestBase httpRequest;
                httpRequest = new HttpGet(uri);
                return httpRequest;
            }
        });
        requestHandlers.put(Method.POST, new HttpMethodFactoryInternal() {
            @Override
            public HttpRequestBase create(ConnioRequest connioRequest, RequestMetaData metaData, URI uri) {
                HttpRequestBase httpRequest;
                HttpPost httpPost = new HttpPost(uri);
                httpPost.setEntity(HttpEntityFactory.create(connioRequest, metaData));
                httpRequest = httpPost;
                return httpRequest;
            }
        });
        requestHandlers.put(Method.PUT, new HttpMethodFactoryInternal() {
            @Override
            public HttpRequestBase create(ConnioRequest connioRequest, RequestMetaData metaData, URI uri) {
                HttpRequestBase httpRequest;
                HttpPut httpPut = new HttpPut(uri);
                httpPut.setEntity(HttpEntityFactory.create(connioRequest, metaData));
                httpRequest = httpPut;
                return httpRequest;
            }
        });
        requestHandlers.put(Method.DELETE, new HttpMethodFactoryInternal() {
            @Override
            public HttpRequestBase create(ConnioRequest connioRequest, RequestMetaData metaData, URI uri) {
                HttpRequestBase httpRequest;
                httpRequest = new HttpDelete(uri);
                return httpRequest;
            }
        });
    }

    private static interface HttpMethodFactoryInternal {
        public HttpRequestBase create(ConnioRequest connioRequest, RequestMetaData metaData, URI uri);
    }
}

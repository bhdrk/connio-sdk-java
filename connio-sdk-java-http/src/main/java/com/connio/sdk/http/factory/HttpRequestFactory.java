package com.connio.sdk.http.factory;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.AbstractConnioRequest;
import com.connio.sdk.api.model.Method;
import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.TypeUtils;
import com.connio.sdk.http.model.ClientConfig;
import com.connio.sdk.http.utils.HttpUtils;
import com.connio.sdk.http.utils.UserAgentInfo;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.*;

import java.net.URI;
import java.util.Map;

import static com.connio.sdk.api.model.Method.*;

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

    public static HttpRequestBase create(ClientConfig clientConfig, AbstractConnioRequest request) {
        return factory.doCreate(clientConfig, request);
    }

    private HttpRequestBase doCreate(ClientConfig clientConfig, AbstractConnioRequest request) {
        HttpRequestBase httpRequest;

        Method method = request.getRequestMetaData().getMethod();
        URI uri = HttpUtils.buildURI(clientConfig, request);

        if (GET.equals(method)) {
            httpRequest = httpGet(request, uri);
        } else if (POST.equals(method)) {
            httpRequest = httpPost(request, uri);
        } else if (PUT.equals(method)) {
            httpRequest = httpPut(request, uri);
        } else if (DELETE.equals(method)) {
            httpRequest = httpDelete(request, uri);
        } else {
            throw new ConnioClientException("Unsupported HTTP method: " + method);
        }

        addHeaders(httpRequest, request);

        return httpRequest;
    }

    private HttpRequestBase httpGet(AbstractConnioRequest request, URI uri) {
        HttpRequestBase httpRequest;
        httpRequest = new HttpGet(uri);
        return httpRequest;
    }

    private HttpRequestBase httpPost(AbstractConnioRequest request, URI uri) {
        HttpRequestBase httpRequest;
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setEntity(HttpEntityFactory.create(request));
        httpRequest = httpPost;
        return httpRequest;
    }

    private HttpRequestBase httpPut(AbstractConnioRequest request, URI uri) {
        HttpRequestBase httpRequest;
        HttpPut httpPut = new HttpPut(uri);
        httpPut.setEntity(HttpEntityFactory.create(request));
        httpRequest = httpPut;
        return httpRequest;
    }

    private HttpRequestBase httpDelete(AbstractConnioRequest request, URI uri) {
        HttpRequestBase httpRequest;
        httpRequest = new HttpDelete(uri);
        return httpRequest;
    }

    private void addHeaders(HttpRequestBase httpRequest, AbstractConnioRequest connioRequest) {
        RequestMetaData metaData = connioRequest.getRequestMetaData();

        httpRequest.addHeader(HttpHeaders.CONTENT_TYPE, metaData.getContentType());
        httpRequest.addHeader(HttpHeaders.USER_AGENT, UserAgentInfo.getUserAgent());

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
    }

    private boolean isIgnoredHeader(String name) {
        return name.equalsIgnoreCase(HttpHeaders.CONTENT_TYPE) ||
                name.equalsIgnoreCase(HttpHeaders.CONTENT_LENGTH) ||
                name.equalsIgnoreCase(HttpHeaders.HOST);
    }
}

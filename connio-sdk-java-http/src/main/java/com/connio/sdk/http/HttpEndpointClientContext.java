package com.connio.sdk.http;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.core.AbstractEndpointClientContext;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.AbstractConnioRequest;
import com.connio.sdk.api.model.ConnioResponse;
import com.connio.sdk.http.factory.HttpClientFactory;
import com.connio.sdk.http.factory.HttpRequestFactory;
import com.connio.sdk.http.factory.HttpResponseFactory;
import com.connio.sdk.http.model.ClientConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.Closeable;
import java.io.IOException;

import static com.connio.sdk.http.utils.IOUtils.closeSilently;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 15.09.2014
 */
public class HttpEndpointClientContext extends AbstractEndpointClientContext implements Closeable {

    private CloseableHttpClient httpClient;

    private ClientConfig clientConfig;

    public HttpEndpointClientContext() {
    }

    @Override
    public void init(ConnioCredentials credentials) {
        this.clientConfig = ClientConfig.instance();
        this.httpClient = HttpClientFactory.create(clientConfig, credentials);
    }

    @Override
    protected <T extends ConnioResponse> T doExecute(AbstractConnioRequest request, Class<T> responseType) {
        CloseableHttpResponse httpResponse = null;
        try {
            HttpRequestBase httpRequest = HttpRequestFactory.create(clientConfig, request);
            httpResponse = httpClient.execute(httpRequest);
            return HttpResponseFactory.create(httpResponse, responseType);
        } catch (IOException e) {
            throw new ConnioClientException("An error occurred while executing http request.", e);
        } finally {
            closeSilently(httpResponse);
        }
    }

    @Override
    public void close() throws IOException {
        httpClient.close();
    }

    @Override
    protected void finalize() throws Throwable {
        closeSilently(this);
        super.finalize();
    }
}

package com.connio.sdk.http.factory;

import com.connio.sdk.http.gzip.GzipRequestInterceptor;
import com.connio.sdk.http.gzip.GzipResponseInterceptor;
import com.connio.sdk.http.model.ClientConfig;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * Responsible for creating and configuring instances of Apache HttpClient4.
 */
public class HttpClientFactory {

    private static HttpClientFactory factory = new HttpClientFactory();

    private HttpClientFactory() {
    }

    public static CloseableHttpClient create(ClientConfig clientConfig) {
        return factory.doCreate(clientConfig);
    }

    private CloseableHttpClient doCreate(ClientConfig clientConfig) {
        ConnectionConfig connectionConfig = getConnectionConfig(clientConfig);
        SocketConfig socketConfig = getSocketConfig(clientConfig);
        RequestConfig requestConfig = getRequestConfig(clientConfig);

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create()
                .setMaxConnPerRoute(clientConfig.getMaxConnections())
                .setMaxConnTotal(clientConfig.getMaxConnections())
                .setDefaultSocketConfig(socketConfig)
                .setDefaultConnectionConfig(connectionConfig)
                .setDefaultRequestConfig(requestConfig);

        setProxy(httpClientBuilder, clientConfig);
        setGzipSupport(httpClientBuilder, clientConfig);

        return httpClientBuilder.build();
    }

    private void setGzipSupport(HttpClientBuilder httpClientBuilder, ClientConfig clientConfig) {
        if (clientConfig.isUseGzip()) {
            httpClientBuilder.addInterceptorLast(new GzipRequestInterceptor());
            httpClientBuilder.addInterceptorLast(new GzipResponseInterceptor());
        }
    }

    private RequestConfig getRequestConfig(ClientConfig clientConfig) {
        return RequestConfig.custom()
                .setSocketTimeout(clientConfig.getSocketTimeout())
                .setConnectTimeout(clientConfig.getConnectionTimeout())
                .setConnectionRequestTimeout(clientConfig.getConnectionRequestTimeout())
                .setStaleConnectionCheckEnabled(true)
                .build();
    }

    private ConnectionConfig getConnectionConfig(ClientConfig clientConfig) {
        /**
         * TODO: Connection configuration
         */
        return ConnectionConfig.DEFAULT;
    }

    private SocketConfig getSocketConfig(ClientConfig clientConfig) {
        return SocketConfig.custom()
                .setSoTimeout(clientConfig.getSocketTimeout())
                .setTcpNoDelay(true)
                .build();
    }


    private void setProxy(HttpClientBuilder httpClientBuilder, ClientConfig clientConfig) {
        String proxyProtocol = clientConfig.getProxyProtocol();
        String proxyHost = clientConfig.getProxyHost();
        int proxyPort = clientConfig.getProxyPort();

        if (isNotEmpty(proxyHost) && proxyPort > -1) {
            if (isNotEmpty(clientConfig.getProxyUsername()) && isNotEmpty(clientConfig.getProxyPassword())) {
                CredentialsProvider credentialsProvider = createCredentialsProvider(clientConfig);
                httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
            }
            HttpHost proxy = new HttpHost(proxyHost, proxyPort, proxyProtocol);
            httpClientBuilder.setProxy(proxy);
        }
    }

    private CredentialsProvider createCredentialsProvider(ClientConfig clientConfig) {
        AuthScope authscope = new AuthScope(clientConfig.getProxyHost(), clientConfig.getPort(), clientConfig.getProxyProtocol());
        Credentials credentials = createCredentials(clientConfig);
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(authscope, credentials);
        return credentialsProvider;
    }

    private Credentials createCredentials(ClientConfig clientConfig) {
        Credentials credentials;

        if (isNotEmpty(clientConfig.getProxyDomain()) || isNotEmpty(clientConfig.getProxyWorkstation())) {
            credentials = new NTCredentials(clientConfig.getProxyUsername(), clientConfig.getProxyPassword(), clientConfig.getProxyWorkstation(), clientConfig.getProxyDomain());
        } else {
            credentials = new UsernamePasswordCredentials(clientConfig.getProxyUsername(), clientConfig.getProxyPassword());
        }
        return credentials;
    }
}
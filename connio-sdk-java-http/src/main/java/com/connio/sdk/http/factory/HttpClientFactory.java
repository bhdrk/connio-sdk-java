package com.connio.sdk.http.factory;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.utils.Asserts;
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
import org.apache.http.impl.client.TargetAuthenticationStrategy;

import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * Responsible for creating and configuring instances of Apache HttpClient4.
 */
public class HttpClientFactory {

    private static HttpClientFactory factory = new HttpClientFactory();

    private HttpClientFactory() {
    }

    public static CloseableHttpClient create(ClientConfig clientConfig, ConnioCredentials credentials) {
        return factory.doCreate(clientConfig, credentials);
    }

    private CloseableHttpClient doCreate(ClientConfig clientConfig, ConnioCredentials credentials) {
        CredentialsProvider credentialsProvider = getCredentialsProvider(clientConfig, credentials);
        ConnectionConfig connectionConfig = getConnectionConfig(clientConfig);
        SocketConfig socketConfig = getSocketConfig(clientConfig);
        RequestConfig requestConfig = getRequestConfig(clientConfig);

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create()
                .setMaxConnPerRoute(clientConfig.getMaxConnections())
                .setMaxConnTotal(clientConfig.getMaxConnections())
                .setDefaultSocketConfig(socketConfig)
                .setDefaultConnectionConfig(connectionConfig)
                .setDefaultRequestConfig(requestConfig)
                .setDefaultCredentialsProvider(credentialsProvider)
                .setTargetAuthenticationStrategy(new TargetAuthenticationStrategy());

        setProxy(httpClientBuilder, clientConfig, credentialsProvider);
        setGzipSupport(httpClientBuilder, clientConfig);

        return httpClientBuilder.build();
    }

    private CredentialsProvider getCredentialsProvider(ClientConfig clientConfig, ConnioCredentials credentials) {
        Asserts.notNull(credentials, "Credentials");
        Asserts.notEmpty(credentials.getAccessKey(), "Credentials.accessKey");
        Asserts.notEmpty(credentials.getSecretKey(), "Credentials.secretKey");

        Credentials usernamePasswordCredentials = new UsernamePasswordCredentials(credentials.getAccessKey(), credentials.getSecretKey());
        AuthScope authscope = new AuthScope(clientConfig.getHost(), clientConfig.getPort());

        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(authscope, usernamePasswordCredentials);

        return credentialsProvider;
    }

    private void setGzipSupport(HttpClientBuilder httpClientBuilder, ClientConfig clientConfig) {
        // Apache HttpClient adds gzip support by default if Accept-Encoding header is not added.
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
                .setAuthenticationEnabled(true)
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

    private void setProxy(HttpClientBuilder httpClientBuilder, ClientConfig clientConfig, CredentialsProvider credentialsProvider) {
        if (hasProxyConfig(clientConfig)) {
            if (hasProxyAuthConfig(clientConfig)) {
                setProxyCredentials(clientConfig, credentialsProvider);
            }
            HttpHost proxy = new HttpHost(clientConfig.getProxyHost(), clientConfig.getProxyPort(), clientConfig.getProxyProtocol());
            httpClientBuilder.setProxy(proxy);
        }
    }

    private boolean hasProxyConfig(ClientConfig clientConfig) {
        return isNotEmpty(clientConfig.getProxyProtocol()) && isNotEmpty(clientConfig.getProxyHost()) && clientConfig.getProxyPort() > 0;
    }

    private boolean hasProxyAuthConfig(ClientConfig clientConfig) {
        return isNotEmpty(clientConfig.getProxyUsername()) && isNotEmpty(clientConfig.getProxyPassword());
    }

    private void setProxyCredentials(ClientConfig clientConfig, CredentialsProvider credentialsProvider) {
        AuthScope authscope = new AuthScope(clientConfig.getProxyHost(), clientConfig.getProxyPort());
        Credentials credentials = createCredentials(clientConfig);
        credentialsProvider.setCredentials(authscope, credentials);
    }

    private Credentials createCredentials(ClientConfig clientConfig) {
        Credentials credentials;

        if (hasNTConfig(clientConfig)) {
            credentials = new NTCredentials(clientConfig.getProxyUsername(), clientConfig.getProxyPassword(), clientConfig.getProxyWorkstation(), clientConfig.getProxyDomain());
        } else {
            credentials = new UsernamePasswordCredentials(clientConfig.getProxyUsername(), clientConfig.getProxyPassword());
        }
        return credentials;
    }

    private boolean hasNTConfig(ClientConfig clientConfig) {
        return isNotEmpty(clientConfig.getProxyDomain()) || isNotEmpty(clientConfig.getProxyWorkstation());
    }
}
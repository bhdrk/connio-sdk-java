package com.connio.sdk.http.factory;

import com.connio.sdk.http.model.ClientConfig;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

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
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create()
                .setMaxConnPerRoute(clientConfig.getMaxConnections())
                .setMaxConnTotal(clientConfig.getMaxConnections())
                .setDefaultSocketConfig(socketConfig)
                .setDefaultConnectionConfig(connectionConfig);
        if (!clientConfig.isUseGzip()) {
            httpClientBuilder.disableContentCompression();
        }
        return httpClientBuilder.build();
    }

    private ConnectionConfig getConnectionConfig(ClientConfig clientConfig) {
        return ConnectionConfig.DEFAULT;
    }

    private SocketConfig getSocketConfig(ClientConfig clientConfig) {
        return SocketConfig.custom()
                .setSoTimeout(clientConfig.getSocketTimeout())
                .setTcpNoDelay(true)
                .build();
    }
}
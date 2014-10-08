package com.connio.sdk.http.internal;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.squareup.okhttp.OkHttpClient;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 02.10.2014
 */
public class ClientFactory {
    private static final ClientFactory factory = new ClientFactory();

    private ClientFactory() {
    }

    public static OkHttpClient create(ConnioCredentials credentials, ClientConfig clientConfig) {
        return factory.doCreate(credentials, clientConfig);
    }

    private OkHttpClient doCreate(ConnioCredentials credentials, ClientConfig clientConfig) {
        OkHttpClient client = new OkHttpClient();

        client.setAuthenticator(new Authenticator(credentials, clientConfig));
        client.setConnectTimeout(clientConfig.getConnectionTimeout(), TimeUnit.MILLISECONDS);
        client.setReadTimeout(clientConfig.getConnectionRequestTimeout(), TimeUnit.MILLISECONDS);

        if (hasProxyConfig(clientConfig)) {
            setProxy(client, clientConfig);
        }

        return client;
    }

    private void setProxy(OkHttpClient client, ClientConfig clientConfig) {
        InetSocketAddress address = InetSocketAddress.createUnresolved(clientConfig.getProxyHost(), clientConfig.getProxyPort());
        Proxy proxy = new Proxy(Proxy.Type.HTTP, address);
        client.setProxy(proxy);
    }

    private boolean hasProxyConfig(ClientConfig clientConfig) {
        return isNotEmpty(clientConfig.getProxyProtocol()) && isNotEmpty(clientConfig.getProxyHost()) && clientConfig.getProxyPort() > 0;
    }

}

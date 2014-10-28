package com.connio.sdk.http.internal;

import com.squareup.okhttp.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOG = LoggerFactory.getLogger(ClientFactory.class);

    public ClientFactory() {
    }

    public OkHttpClient create(ClientConfig clientConfig) {
        OkHttpClient client = new OkHttpClient();

        client.setConnectTimeout(clientConfig.getConnectionTimeout(), TimeUnit.MILLISECONDS);
        client.setReadTimeout(clientConfig.getConnectionRequestTimeout(), TimeUnit.MILLISECONDS);

        if (hasProxyConfig(clientConfig)) {
            if (LOG.isDebugEnabled())
                LOG.debug("Setting up proxy for " + clientConfig.getProxyHost() + ":" + clientConfig.getProxyPort());

            setProxy(client, clientConfig);
        }

        return client;
    }

    private void setProxy(OkHttpClient client, ClientConfig clientConfig) {
        InetSocketAddress address = InetSocketAddress.createUnresolved(clientConfig.getProxyHost(), clientConfig.getProxyPort());
        Proxy.Type proxyType = clientConfig.getProxyType() == null ? Proxy.Type.HTTP : Proxy.Type.valueOf(clientConfig.getProxyType());
        Proxy proxy = new Proxy(proxyType, address);

        client.setProxy(proxy);
        client.setAuthenticator(new ProxyAuthenticator(clientConfig));
    }

    private boolean hasProxyConfig(ClientConfig clientConfig) {
        return isNotEmpty(clientConfig.getProxyHost()) && clientConfig.getProxyPort() > 0;
    }

}

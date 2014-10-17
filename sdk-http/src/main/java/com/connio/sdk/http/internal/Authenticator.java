package com.connio.sdk.http.internal;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.Proxy;

import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 02.10.2014
 */
public class Authenticator implements com.squareup.okhttp.Authenticator {

    private ConnioCredentials credentials;

    private ClientConfig clientConfig;

    public Authenticator(ConnioCredentials credentials, ClientConfig clientConfig) {
        this.credentials = credentials;
        this.clientConfig = clientConfig;
    }

    @Override
    public Request authenticate(Proxy proxy, Response response) throws IOException {
        String basic = Credentials.basic(credentials.getAccessKey(), credentials.getSecretKey());
        return response.request()
                .newBuilder()
                .header("Authorization", basic)
                .build();
    }

    @Override
    public Request authenticateProxy(Proxy proxy, Response response) throws IOException {
        Request.Builder builder = response.request().newBuilder();
        String proxyUsername = clientConfig.getProxyUsername();
        String proxyPassword = clientConfig.getProxyPassword();

        if (isNotEmpty(proxyUsername) && isNotEmpty(proxyPassword)) {
            String basic = Credentials.basic(proxyUsername, proxyPassword);
            builder.header("Proxy-Authorization", basic);
        }

        return builder.build();
    }
}

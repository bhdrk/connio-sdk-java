package com.connio.sdk.http.factory;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.utils.Asserts;
import com.connio.sdk.http.model.ClientConfig;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;

import java.util.Arrays;

import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 26.09.2014
 */
public class HttpClientContextFactory {
    private static final HttpClientContextFactory instance = new HttpClientContextFactory();

    public static HttpClientContext create(ClientConfig clientConfig, ConnioCredentials credentials) {
        return instance.doCreate(clientConfig, credentials);
    }

    private HttpClientContext doCreate(ClientConfig clientConfig, ConnioCredentials credentials) {
        CredentialsProvider credentialsProvider = getCredentialsProvider(clientConfig, credentials);
        AuthCache authCache = getAuthCache(clientConfig);
        RequestConfig requestConfig = getRequestConfig(clientConfig);

        HttpClientContext context = HttpClientContext.create();
        context.setAuthCache(authCache);
        context.setCredentialsProvider(credentialsProvider);
        context.setRequestConfig(requestConfig);
        return context;
    }

    private AuthCache getAuthCache(ClientConfig clientConfig) {
        HttpHost target = new HttpHost(clientConfig.getHost(), clientConfig.getPort());
        AuthCache authCache = new BasicAuthCache();
        authCache.put(target, new BasicScheme());
        return authCache;
    }

    private CredentialsProvider getCredentialsProvider(ClientConfig clientConfig, ConnioCredentials credentials) {
        Asserts.notNull(credentials, "Credentials");
        Asserts.notEmpty(credentials.getAccessKey(), "Credentials.accessKey");
        Asserts.notEmpty(credentials.getSecretKey(), "Credentials.secretKey");

        Credentials usernamePasswordCredentials = new UsernamePasswordCredentials(credentials.getAccessKey(), credentials.getSecretKey());
        AuthScope authscope = new AuthScope(clientConfig.getHost(), clientConfig.getPort());

        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(authscope, usernamePasswordCredentials);

        if (hasProxyConfig(clientConfig) && hasProxyAuthConfig(clientConfig)) {
            setProxyCredentials(clientConfig, credentialsProvider);
        }

        return credentialsProvider;
    }

    private RequestConfig getRequestConfig(ClientConfig clientConfig) {
        RequestConfig.Builder builder = RequestConfig.custom()
                .setSocketTimeout(clientConfig.getSocketTimeout())
                .setConnectTimeout(clientConfig.getConnectionTimeout())
                .setConnectionRequestTimeout(clientConfig.getConnectionRequestTimeout())
                .setStaleConnectionCheckEnabled(true)
                .setTargetPreferredAuthSchemes(Arrays.asList("basic"))
                .setAuthenticationEnabled(true);

        if (hasProxyConfig(clientConfig)) {
            HttpHost proxy = new HttpHost(clientConfig.getProxyHost(), clientConfig.getProxyPort(), clientConfig.getProxyProtocol());
            builder.setProxy(proxy);
        }

        return builder.build();
    }

    private boolean hasProxyConfig(ClientConfig clientConfig) {
        return isNotEmpty(clientConfig.getProxyProtocol()) && isNotEmpty(clientConfig.getProxyHost()) && clientConfig.getProxyPort() > 0;
    }

    private boolean hasProxyAuthConfig(ClientConfig clientConfig) {
        return isNotEmpty(clientConfig.getProxyUsername()) && isNotEmpty(clientConfig.getProxyPassword());
    }

    private void setProxyCredentials(ClientConfig clientConfig, CredentialsProvider credentialsProvider) {
        AuthScope authscope = new AuthScope(clientConfig.getProxyHost(), clientConfig.getProxyPort());
        Credentials credentials = createProxyCredentials(clientConfig);
        credentialsProvider.setCredentials(authscope, credentials);
    }

    private Credentials createProxyCredentials(ClientConfig clientConfig) {
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

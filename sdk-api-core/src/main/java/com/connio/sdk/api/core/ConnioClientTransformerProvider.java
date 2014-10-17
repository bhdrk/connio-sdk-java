package com.connio.sdk.api.core;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.auth.ConnioCredentialsManager;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.utils.Asserts;

import java.util.ServiceLoader;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class ConnioClientTransformerProvider {

    private static ConnioClientTransformer context = load();

    public static ConnioClientTransformer get() {
        return context;
    }

    private static ConnioClientTransformer load() {
        ConnioCredentials credentials = getCredentials();
        ServiceLoader<ConnioClientTransformer> services = ServiceLoader.load(ConnioClientTransformer.class);
        for (ConnioClientTransformer service : services) {
            service.init(credentials);
            return service;
        }
        throw new ConnioClientException("Service not found for com.connio.sdk.api.core.ConnioClientTransformer");
    }

    private static ConnioCredentials getCredentials() {
        ConnioCredentials credentials = ConnioCredentialsManager.getCredentials();
        if (credentials == null) {
            throw new ConnioClientException("Credentials not provided!");
        }
        Asserts.notEmpty(credentials.getAccessKey(), "Credentials.accessKey");
        Asserts.notEmpty(credentials.getSecretKey(), "Credentials.secretKey");
        return credentials;
    }
}

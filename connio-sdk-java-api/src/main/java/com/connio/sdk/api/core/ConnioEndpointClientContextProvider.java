package com.connio.sdk.api.core;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.auth.ConnioCredentialsManager;
import com.connio.sdk.api.exception.ConnioClientException;

import java.util.ServiceLoader;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class ConnioEndpointClientContextProvider {

    private static ConnioEndpointClientContext context = load();

    public static ConnioEndpointClientContext get() {
        return context;
    }

    private static ConnioEndpointClientContext load() {
        ConnioCredentials credentials = getCredentials();
        ServiceLoader<ConnioEndpointClientContext> services = ServiceLoader.load(ConnioEndpointClientContext.class);
        for (ConnioEndpointClientContext service : services) {
            service.init(credentials);
            return service;
        }
        throw new ConnioClientException("Service not found for com.connio.sdk.api.core.ConnioEndpointClientContext");
    }

    private static ConnioCredentials getCredentials() {
        ConnioCredentials credentials = ConnioCredentialsManager.getCredentials();
        if (credentials == null) {
            throw new ConnioClientException("Credentials not provided!");
        }
        return credentials;
    }
}

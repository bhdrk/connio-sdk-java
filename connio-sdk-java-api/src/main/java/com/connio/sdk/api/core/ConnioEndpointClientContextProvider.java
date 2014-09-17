package com.connio.sdk.api.core;

import com.connio.sdk.api.UnsupportedRequestHandler;
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
        ServiceLoader<ConnioEndpointClientContext> services = ServiceLoader.load(ConnioEndpointClientContext.class);
        for (ConnioEndpointClientContext service : services) {
            doInternalLoad(service);
            return service;
        }
        throw new ConnioClientException("Service not found for com.connio.sdk.api.core.ConnioEndpointClientContext");
    }

    private static void doInternalLoad(ConnioEndpointClientContext context) {
        context.addRequestHandler(new UnsupportedRequestHandler());
    }

}

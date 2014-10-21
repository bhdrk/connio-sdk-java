package com.connio.sdk.api.core;

import com.connio.sdk.api.exception.ConnioClientException;

import java.util.Iterator;
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
        ServiceLoader<ConnioClientTransformer> services = ServiceLoader.load(ConnioClientTransformer.class);
        Iterator<ConnioClientTransformer> serviceIterator = services.iterator();

        if (serviceIterator.hasNext()) {
            return serviceIterator.next();
        }

        throw new ConnioClientException("Service not found for com.connio.sdk.api.core.ConnioClientTransformer");
    }
}

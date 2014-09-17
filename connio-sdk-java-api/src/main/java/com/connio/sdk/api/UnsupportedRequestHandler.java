package com.connio.sdk.api;

import com.connio.sdk.api.core.ConnioRequestHandler;
import com.connio.sdk.api.core.UnsupportedOperation;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.ConnioRequest;

import java.lang.annotation.Annotation;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public class UnsupportedRequestHandler implements ConnioRequestHandler {

    @Override
    public boolean isHandlerFor(ConnioRequest request) {
        if (request != null) {
            for (Annotation annotation : request.getClass().getDeclaredAnnotations()) {
                if (annotation instanceof UnsupportedOperation) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public ConnioRequest handleRequest(ConnioRequest request) {
        throw new ConnioClientException(request.getClass().getSimpleName() + " not supported yet.");
    }

    @Override
    public String getKey() {
        return getClass().getName();
    }
}

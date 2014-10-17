package com.connio.sdk.api.core;

import com.connio.sdk.api.model.ConnioRequest;
import com.connio.sdk.api.model.ConnioResponse;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public interface ConnioRequestHandler extends Serializable {

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public <RS extends ConnioResponse> boolean isHandlerFor(ConnioRequest<RS> request);

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public <RS extends ConnioResponse> ConnioRequest<RS> handleRequest(ConnioRequest<RS> request);

    /**
     * TODO: javadoc
     *
     * @return
     */
    public String getKey();
}

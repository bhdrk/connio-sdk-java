package com.connio.sdk.api.core;

import com.connio.sdk.api.model.ConnioRequest;

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
    public boolean isHandlerFor(ConnioRequest request);

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public ConnioRequest handleRequest(ConnioRequest request);

    /**
     * TODO: javadoc
     *
     * @return
     */
    public String getKey();
}

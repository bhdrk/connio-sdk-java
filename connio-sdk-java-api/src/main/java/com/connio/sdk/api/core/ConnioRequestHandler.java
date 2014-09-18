package com.connio.sdk.api.core;

import com.connio.sdk.api.model.AbstractConnioRequest;

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
    public boolean isHandlerFor(AbstractConnioRequest request);

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public AbstractConnioRequest handleRequest(AbstractConnioRequest request);

    /**
     * TODO: javadoc
     *
     * @return
     */
    public String getKey();
}

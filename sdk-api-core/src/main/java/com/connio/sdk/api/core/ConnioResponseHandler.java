package com.connio.sdk.api.core;

import com.connio.sdk.api.model.ConnioResponse;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 16.09.2014
 */
public interface ConnioResponseHandler extends Serializable {

    /**
     * TODO: javadoc
     *
     * @param response
     * @return
     */
    public boolean isHandlerFor(ConnioResponse response);

    /**
     * TODO: javadoc
     *
     * @param response
     * @return
     */
    public ConnioResponse handleResponse(ConnioResponse response);

    /**
     * TODO: javadoc
     *
     * @return
     */
    public String getKey();
}

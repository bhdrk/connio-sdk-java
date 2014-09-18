package com.connio.sdk.api.core;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.model.AbstractConnioRequest;
import com.connio.sdk.api.model.ConnioResponse;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 15.09.2014
 */
public interface ConnioEndpointClientContext {

    /**
     * TODO: javadoc
     *
     * @param credentials
     */
    public void init(ConnioCredentials credentials);

    /**
     * TODO: javadoc
     *
     * @param request
     * @param responseType
     * @param <T>
     * @return
     */
    public <T extends ConnioResponse> T execute(AbstractConnioRequest request, Class<T> responseType);

    /**
     * TODO: javadoc
     *
     * @param handler
     */
    public void addRequestHandler(ConnioRequestHandler handler);

    /**
     * TODO: javadoc
     *
     * @param handler
     */
    public void addResponseHandler(ConnioResponseHandler handler);
}

package com.connio.sdk.api.core;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.model.ConnioRequest;
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
     * @param <RS>
     * @return
     */
    public <RS extends ConnioResponse> RS execute(ConnioRequest<RS> request);

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

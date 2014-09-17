package com.connio.sdk.api.systemservices.apps;

import com.connio.sdk.api.core.ConnioEndpointClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioEndpointException;
import com.connio.sdk.api.systemservices.apps.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public interface AppEndpointClient extends ConnioEndpointClient {

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public GetAppDetailsResponse getAppDetails(GetAppDetailsRequest request)
            throws ConnioEndpointException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @return
     */
    public GetAllAppDetailsResponse getAllAppDetails()
            throws ConnioEndpointException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public CreateAppResponse createApp(CreateAppRequest request)
            throws ConnioEndpointException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public UpdateAppResponse updateApp(UpdateAppRequest request)
            throws ConnioEndpointException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public DeleteAppResponse deleteApp(DeleteAppRequest request)
            throws ConnioEndpointException, ConnioClientException;

}

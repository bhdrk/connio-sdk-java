package com.connio.sdk.api.systemservices.apps;

import com.connio.sdk.api.core.ConnioEndpointClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
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
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @return
     */
    public GetAllAppDetailsResponse getAllAppDetails()
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public CreateAppResponse createApp(CreateAppRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public UpdateAppResponse updateApp(UpdateAppRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public DeleteAppResponse deleteApp(DeleteAppRequest request)
            throws ConnioServiceException, ConnioClientException;

}

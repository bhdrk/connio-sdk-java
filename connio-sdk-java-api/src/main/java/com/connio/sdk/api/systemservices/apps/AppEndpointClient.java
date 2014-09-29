package com.connio.sdk.api.systemservices.apps;

import com.connio.sdk.api.core.ConnioEndpointClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.Deleted;
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
     * @param sidOrName
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public AppDetails getAppDetails(String sidOrName)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public AppResultSet getAllAppDetails()
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param app
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public AppDetails createApp(App app)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param sidOrName
     * @param app
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public AppDetails updateApp(String sidOrName, App app)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param sidOrName
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public Deleted deleteApp(String sidOrName)
            throws ConnioServiceException, ConnioClientException;

}

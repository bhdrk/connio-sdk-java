package com.connio.sdk.api.systemservices.apps;

import com.connio.sdk.api.core.AbstractClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.apps.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 22.09.2014
 */
public class AppClient extends AbstractClient implements IAppClient {

    /**
     * TODO: javadoc
     *
     * @param sidOrName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public AppDetails getAppDetails(String sidOrName)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetAppDetailsRequest(sidOrName));
    }

    /**
     * TODO: javadoc
     *
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public AppResultSet getAllAppDetails()
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetAllAppDetailsRequest());
    }

    /**
     * TODO: javadoc
     *
     * @param app
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public AppDetails createApp(App app)
            throws ConnioServiceException, ConnioClientException {
        return execute(new CreateAppRequest(app));
    }

    /**
     * TODO: javadoc
     *
     * @param sidOrName
     * @param app
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public AppDetails updateApp(String sidOrName, App app)
            throws ConnioServiceException, ConnioClientException {
        return execute(new UpdateAppRequest(sidOrName, app));
    }

    /**
     * TODO: javadoc
     *
     * @param sidOrName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public Deleted deleteApp(String sidOrName)
            throws ConnioServiceException, ConnioClientException {
        return execute(new DeleteAppRequest(sidOrName));
    }
}

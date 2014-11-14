package com.connio.sdk.api.systemservices.apps;

import com.connio.sdk.api.core.AbstractClient;
import com.connio.sdk.api.core.ConnioClientTransformer;
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

    public AppClient() {
    }

    public AppClient(String credentialsProfile) {
        super(credentialsProfile);
    }

    public AppClient(String credentialsProfile, ConnioClientTransformer context) {
        super(credentialsProfile, context);
    }

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public AppDetails getAppDetails(String appSidOrName)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetAppDetailsRequest(appSidOrName));
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
     * @param appSidOrName
     * @param app
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public AppDetails updateApp(String appSidOrName, App app)
            throws ConnioServiceException, ConnioClientException {
        return execute(new UpdateAppRequest(appSidOrName, app));
    }

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public Deleted deleteApp(String appSidOrName)
            throws ConnioServiceException, ConnioClientException {
        return execute(new DeleteAppRequest(appSidOrName));
    }

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public AppUsageDetails getAppUsageDetails(String appSidOrName)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetAppUsageDetailsRequest(appSidOrName));
    }

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public AppLogList getAppLogs(String appSidOrName)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetAppLogsRequest(appSidOrName));
    }

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public TriggerResultSet getTriggers(String appSidOrName) {
        return execute(new GetAppTriggersRequest(appSidOrName));
    }

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public TriggerDetails createTrigger(String appSidOrName, Trigger trigger) {
        return execute(new CreateAppTriggerRequest(appSidOrName, trigger));
    }

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public Deleted deleteTrigger(String appSidOrName, String triggerSid) {
        return execute(new DeleteAppTriggerRequest(appSidOrName, triggerSid));
    }
}

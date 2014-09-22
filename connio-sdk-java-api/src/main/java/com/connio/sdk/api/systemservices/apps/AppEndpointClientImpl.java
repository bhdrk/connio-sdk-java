package com.connio.sdk.api.systemservices.apps;

import com.connio.sdk.api.core.ConnioEndpointClientContext;
import com.connio.sdk.api.core.ConnioEndpointClientContextProvider;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.systemservices.apps.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 22.09.2014
 */
public class AppEndpointClientImpl implements AppEndpointClient {

    private ConnioEndpointClientContext context;

    public AppEndpointClientImpl() {
        context = ConnioEndpointClientContextProvider.get();
    }

    @Override
    public GetAppDetailsResponse getAppDetails(GetAppDetailsRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request, GetAppDetailsResponse.class);
    }

    @Override
    public GetAllAppDetailsResponse getAllAppDetails(GetAllAppDetailsRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request, GetAllAppDetailsResponse.class);
    }

    @Override
    public CreateAppResponse createApp(CreateAppRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request, CreateAppResponse.class);
    }

    @Override
    public UpdateAppResponse updateApp(UpdateAppRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request, UpdateAppResponse.class);
    }

    @Override
    public DeleteAppResponse deleteApp(DeleteAppRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request, DeleteAppResponse.class);
    }
}

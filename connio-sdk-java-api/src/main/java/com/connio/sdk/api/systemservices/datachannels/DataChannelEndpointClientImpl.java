package com.connio.sdk.api.systemservices.datachannels;

import com.connio.sdk.api.core.ConnioEndpointClientContext;
import com.connio.sdk.api.core.ConnioEndpointClientContextProvider;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.systemservices.datachannels.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 23.09.2014
 */
public class DataChannelEndpointClientImpl implements DataChannelEndpointClient {

    private ConnioEndpointClientContext context;

    public DataChannelEndpointClientImpl() {
        context = ConnioEndpointClientContextProvider.get();
    }

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public GetDataChannelDetailsResponse getDataChannelDetails(GetDataChannelDetailsRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request);
    }

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public GetAllDataChannelDetailsResponse getAllDataChannelDetails(GetAllDataChannelDetailsRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request);
    }

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public CreateDataChannelResponse createDataChannel(CreateDataChannelRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request);
    }

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public UpdateDataChannelResponse updateDataChannel(UpdateDataChannelRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request);
    }

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public DeleteDataChannelResponse deleteDataChannel(DeleteDataChannelRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request);
    }
}

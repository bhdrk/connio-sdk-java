package com.connio.sdk.api.systemservices.datachannels;

import com.connio.sdk.api.core.AbstractEndpointClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.datachannels.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 23.09.2014
 */
public class DataChannelEndpointClientImpl extends AbstractEndpointClient implements DataChannelEndpointClient {

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @param channelSidOrName
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public DataChannelDetails getDataChannelDetails(String appSidOrName, String channelSidOrName)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetDataChannelDetailsRequest(appSidOrName, channelSidOrName));
    }

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public DataChannelResultSet getAllDataChannelDetails(String appSidOrName)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetAllDataChannelDetailsRequest(appSidOrName));
    }

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @param dataChannel
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public DataChannelDetails createDataChannel(String appSidOrName, DataChannel dataChannel)
            throws ConnioServiceException, ConnioClientException {
        return execute(new CreateDataChannelRequest(appSidOrName, dataChannel));
    }

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @param channelSidOrName
     * @param dataChannelUpdate
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public DataChannelDetails updateDataChannel(String appSidOrName, String channelSidOrName, DataChannelUpdate dataChannelUpdate)
            throws ConnioServiceException, ConnioClientException {
        return execute(new UpdateDataChannelRequest(appSidOrName, channelSidOrName, dataChannelUpdate));
    }

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @param channelSidOrName
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public Deleted deleteDataChannel(String appSidOrName, String channelSidOrName)
            throws ConnioServiceException, ConnioClientException {
        return execute(new DeleteDataChannelRequest(appSidOrName, channelSidOrName));
    }
}

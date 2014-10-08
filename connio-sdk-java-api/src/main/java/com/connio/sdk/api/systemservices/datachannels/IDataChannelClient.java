package com.connio.sdk.api.systemservices.datachannels;

import com.connio.sdk.api.core.ConnioEndpointClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.datachannels.model.DataChannel;
import com.connio.sdk.api.systemservices.datachannels.model.DataChannelDetails;
import com.connio.sdk.api.systemservices.datachannels.model.DataChannelResultSet;
import com.connio.sdk.api.systemservices.datachannels.model.DataChannelUpdate;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public interface IDataChannelClient extends ConnioEndpointClient {

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @param channelSidOrName
     * @return
     */
    public DataChannelDetails getDataChannelDetails(String appSidOrName, String channelSidOrName)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @return
     */
    public DataChannelResultSet getAllDataChannelDetails(String appSidOrName)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @param dataChannel
     * @return
     */
    public DataChannelDetails createDataChannel(String appSidOrName, DataChannel dataChannel)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @param channelSidOrName
     * @param dataChannelUpdate
     * @return
     */
    public DataChannelDetails updateDataChannel(String appSidOrName, String channelSidOrName, DataChannelUpdate dataChannelUpdate)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param appSidOrName
     * @param channelSidOrName
     * @return
     */
    public Deleted deleteDataChannel(String appSidOrName, String channelSidOrName)
            throws ConnioServiceException, ConnioClientException;
}

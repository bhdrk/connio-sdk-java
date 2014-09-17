package com.connio.sdk.api.systemservices.datachannels;

import com.connio.sdk.api.core.ConnioEndpointClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioEndpointException;
import com.connio.sdk.api.systemservices.datachannels.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public interface DataChannelEndpointClient extends ConnioEndpointClient {

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public GetDataChannelDetailsResponse getDataChannelDetails(GetDataChannelDetailsRequest request)
            throws ConnioEndpointException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @return
     */
    public GetAllDataChannelDetailsResponse getAllDataChannelDetails(GetAllDataChannelDetailsRequest request)
            throws ConnioEndpointException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public CreateDataChannelResponse createDataChannel(CreateDataChannelRequest request)
            throws ConnioEndpointException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public UpdateDataChannelResponse updateDataChannel(UpdateDataChannelRequest request)
            throws ConnioEndpointException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public DeleteDataChannelResponse deleteDataChannel(DeleteDataChannelRequest request)
            throws ConnioEndpointException, ConnioClientException;
}

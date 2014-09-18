package com.connio.sdk.api.systemservices.datachannels;

import com.connio.sdk.api.core.ConnioEndpointClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
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
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @return
     */
    public GetAllDataChannelDetailsResponse getAllDataChannelDetails(GetAllDataChannelDetailsRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public CreateDataChannelResponse createDataChannel(CreateDataChannelRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public UpdateDataChannelResponse updateDataChannel(UpdateDataChannelRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public DeleteDataChannelResponse deleteDataChannel(DeleteDataChannelRequest request)
            throws ConnioServiceException, ConnioClientException;
}

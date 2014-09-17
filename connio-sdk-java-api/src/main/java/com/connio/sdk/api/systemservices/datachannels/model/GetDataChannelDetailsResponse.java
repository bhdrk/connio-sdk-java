package com.connio.sdk.api.systemservices.datachannels.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class GetDataChannelDetailsResponse extends DataChannelEndpointResponse {

    /**
     * TODO: javadoc
     */
    private DataChannelDetails dataChannelDetails;

    public DataChannelDetails getDataChannelDetails() {
        return dataChannelDetails;
    }

    public void setDataChannelDetails(DataChannelDetails dataChannelDetails) {
        this.dataChannelDetails = dataChannelDetails;
    }
}

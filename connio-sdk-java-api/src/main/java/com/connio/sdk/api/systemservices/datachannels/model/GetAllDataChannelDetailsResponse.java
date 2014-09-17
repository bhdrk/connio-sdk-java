package com.connio.sdk.api.systemservices.datachannels.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class GetAllDataChannelDetailsResponse extends DataChannelEndpointResponse {

    /**
     * TODO: javadoc
     */
    private DataChannelResultSet dataChannelResultSet;

    public DataChannelResultSet getDataChannelResultSet() {
        return dataChannelResultSet;
    }

    public void setDataChannelResultSet(DataChannelResultSet dataChannelResultSet) {
        this.dataChannelResultSet = dataChannelResultSet;
    }
}

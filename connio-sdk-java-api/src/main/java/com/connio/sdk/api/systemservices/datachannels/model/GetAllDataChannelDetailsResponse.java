package com.connio.sdk.api.systemservices.datachannels.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class GetAllDataChannelDetailsResponse extends DataChannelEndpointResponse<DataChannelResultSet> {

    private DataChannelResultSet result;

    @Override
    public DataChannelResultSet getResult() {
        return result;
    }

    @Override
    public void setResult(DataChannelResultSet result) {
        this.result = result;
    }
}

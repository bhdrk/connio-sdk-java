package com.connio.sdk.api.systemservices.datachannels.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class CreateDataChannelResponse extends DataChannelEndpointResponse<DataChannelDetails> {

    private DataChannelDetails result;

    @Override
    public DataChannelDetails getResult() {
        return result;
    }

    @Override
    public void setResult(DataChannelDetails result) {
        this.result = result;
    }
}

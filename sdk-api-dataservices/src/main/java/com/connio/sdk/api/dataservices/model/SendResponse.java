package com.connio.sdk.api.dataservices.model;

/**
 * Created by bdirik on 17.10.2014.
 */
public class SendResponse extends DataEndpointResponse<DataFeedDetails> {

    private DataFeedDetails result;

    @Override
    public DataFeedDetails getResult() {
        return result;
    }

    @Override
    public void setResult(DataFeedDetails result) {
        this.result = result;
    }
}

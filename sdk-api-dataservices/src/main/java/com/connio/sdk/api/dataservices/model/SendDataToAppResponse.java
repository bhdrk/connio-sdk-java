package com.connio.sdk.api.dataservices.model;

/**
 * TODO: javadoc
 *
 * Created by bdirik on 17.10.2014.
 */
public class SendDataToAppResponse extends DataResponse<DataFeedDetails> {

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

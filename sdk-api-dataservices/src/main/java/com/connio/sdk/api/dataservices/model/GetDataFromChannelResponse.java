package com.connio.sdk.api.dataservices.model;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 20.10.2014.
 */
public class GetDataFromChannelResponse extends DataEndpointResponse<DataPointResultSet> {

    private DataPointResultSet result;

    @Override
    public DataPointResultSet getResult() {
        return result;
    }

    @Override
    public void setResult(DataPointResultSet result) {
        this.result = result;
    }
}

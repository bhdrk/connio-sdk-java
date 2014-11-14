package com.connio.sdk.api.systemservices.apps.model;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 14.11.2014.
 */
public class GetAppTriggersResponse extends AppResponse<TriggerResultSet> {

    private TriggerResultSet result;

    @Override
    public TriggerResultSet getResult() {
        return result;
    }

    @Override
    public void setResult(TriggerResultSet result) {
        this.result = result;
    }
}

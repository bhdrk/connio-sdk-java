package com.connio.sdk.api.systemservices.apps.model;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 14.11.2014.
 */
public class CreateAppTriggerResponse extends AppResponse<TriggerDetails> {

    private TriggerDetails result;

    @Override
    public TriggerDetails getResult() {
        return result;
    }

    @Override
    public void setResult(TriggerDetails result) {
        this.result = result;
    }
}

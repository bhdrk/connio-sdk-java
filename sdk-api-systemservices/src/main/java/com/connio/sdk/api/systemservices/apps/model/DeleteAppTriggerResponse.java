package com.connio.sdk.api.systemservices.apps.model;

import com.connio.sdk.api.model.Deleted;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 14.11.2014.
 */
public class DeleteAppTriggerResponse extends AppResponse<Deleted> {

    private Deleted result;

    @Override
    public Deleted getResult() {
        return result;
    }

    @Override
    public void setResult(Deleted result) {
        this.result = result;
    }
}

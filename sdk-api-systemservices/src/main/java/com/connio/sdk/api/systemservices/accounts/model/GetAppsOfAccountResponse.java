package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.systemservices.apps.model.AppResultSet;

/**
 * Created by bdirik on 13.11.2014.
 */
public class GetAppsOfAccountResponse extends AccountResponse<AppResultSet> {

    private AppResultSet result;

    public GetAppsOfAccountResponse() {
    }

    public GetAppsOfAccountResponse(AppResultSet result) {
        this.result = result;
    }

    @Override
    public AppResultSet getResult() {
        return result;
    }

    @Override
    public void setResult(AppResultSet result) {
        this.result = result;
    }
}

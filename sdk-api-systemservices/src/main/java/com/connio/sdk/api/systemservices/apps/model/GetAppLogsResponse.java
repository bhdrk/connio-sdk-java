package com.connio.sdk.api.systemservices.apps.model;

/**
 * TODO:javadoc
 * <p/>
 * Created by bdirik on 13.11.2014.
 */
public class GetAppLogsResponse extends AppResponse<AppLogList> {

    private AppLogList result;

    @Override
    public AppLogList getResult() {
        return result;
    }

    @Override
    public void setResult(AppLogList result) {
        this.result = result;
    }
}

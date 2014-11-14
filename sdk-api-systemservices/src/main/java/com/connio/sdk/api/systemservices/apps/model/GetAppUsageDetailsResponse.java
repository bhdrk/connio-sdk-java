package com.connio.sdk.api.systemservices.apps.model;

/**
 * TODO:javadoc
 * <p/>
 * Created by bdirik on 13.11.2014.
 */
public class GetAppUsageDetailsResponse extends AppResponse<AppUsageDetails> {

    private AppUsageDetails result;

    @Override
    public AppUsageDetails getResult() {
        return result;
    }

    @Override
    public void setResult(AppUsageDetails result) {
        this.result = result;
    }
}

package com.connio.sdk.api.systemservices.apps.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO:javadoc
 * <p/>
 * Created by bdirik on 13.11.2014.
 */
public class GetAppUsageDetailsRequest extends AppRequest<GetAppUsageDetailsResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(appSidOrName, "AppName or AppSid");

        metaData.setMethod(GET);
        metaData.addPath("/{app}/_usage");
        metaData.addPathParam("app", appSidOrName);
    }

    /**
     * TODO: javadoc
     */
    private String appSidOrName;

    public GetAppUsageDetailsRequest() {
    }

    public GetAppUsageDetailsRequest(String appSidOrName) {
        this.appSidOrName = appSidOrName;
    }

    public String getAppSidOrName() {
        return appSidOrName;
    }

    public void setAppSidOrName(String appSidOrName) {
        this.appSidOrName = appSidOrName;
    }
}

package com.connio.sdk.api.systemservices.apps.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class GetAppDetailsRequest extends AppRequest<GetAppDetailsResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(appSidOrName, "AppName or AppSid");

        metaData.setMethod(GET);
        metaData.addPath("/{app}");
        metaData.addPathParam("app", appSidOrName);
    }

    /**
     * TODO: javadoc
     */
    private String appSidOrName;

    public GetAppDetailsRequest() {
    }

    public GetAppDetailsRequest(String appSidOrName) {
        this.appSidOrName = appSidOrName;
    }

    public String getAppSidOrName() {
        return appSidOrName;
    }

    public void setAppSidOrName(String appSidOrName) {
        this.appSidOrName = appSidOrName;
    }

}

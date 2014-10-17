package com.connio.sdk.api.systemservices.apps.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.DELETE;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class DeleteAppRequest extends AppEndpointRequest<DeleteAppResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(appId, "AppName or AppSid");

        metaData.setMethod(DELETE);
        metaData.addPath("/{app-id}");
        metaData.addPathParam("app-id", appId);
    }

    private String appId;

    public DeleteAppRequest() {
    }

    public DeleteAppRequest(String appId) {
        this.appId = appId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}

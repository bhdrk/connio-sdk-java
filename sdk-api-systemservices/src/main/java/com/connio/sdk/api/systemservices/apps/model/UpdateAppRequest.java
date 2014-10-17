package com.connio.sdk.api.systemservices.apps.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.PUT;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class UpdateAppRequest extends AppEndpointRequest<UpdateAppResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(app, "App");
        Asserts.notNull(appId, "AppName or AppSid");

        metaData.setMethod(PUT);
        metaData.addPath("/{app-id}");
        metaData.addPathParam("app-id", getAppId());
        metaData.setRequestContent(app);
    }

    /**
     * TODO: javadoc
     */
    private App app;

    /**
     * TODO: javadoc
     */
    private String appId;

    public UpdateAppRequest() {
    }

    public UpdateAppRequest(String appId, App app) {
        this.appId = appId;
        this.app = app;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}

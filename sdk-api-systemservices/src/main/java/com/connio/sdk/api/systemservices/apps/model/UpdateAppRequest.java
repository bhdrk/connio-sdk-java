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
public class UpdateAppRequest extends AppRequest<UpdateAppResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(app, "App");
        Asserts.notEmpty(appSidOrName, "AppName or AppSid");

        metaData.setMethod(PUT);
        metaData.addPath("/{app}");
        metaData.addPathParam("app", appSidOrName);
        metaData.setRequestContent(app);
    }

    /**
     * TODO: javadoc
     */
    private App app;

    /**
     * TODO: javadoc
     */
    private String appSidOrName;

    public UpdateAppRequest() {
    }

    public UpdateAppRequest(String appSidOrName, App app) {
        this.appSidOrName = appSidOrName;
        this.app = app;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public String getAppSidOrName() {
        return appSidOrName;
    }

    public void setAppSidOrName(String appSidOrName) {
        this.appSidOrName = appSidOrName;
    }
}

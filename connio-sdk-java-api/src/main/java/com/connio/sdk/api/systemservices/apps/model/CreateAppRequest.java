package com.connio.sdk.api.systemservices.apps.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.POST;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class CreateAppRequest extends AppEndpointRequest {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(app, "App");

        metaData.setMethod(POST);
        metaData.setRequestContent(app);
    }

    /**
     * TODO: javadoc
     */
    private App app;

    public CreateAppRequest() {
    }

    public CreateAppRequest(App app) {
        this.app = app;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }
}

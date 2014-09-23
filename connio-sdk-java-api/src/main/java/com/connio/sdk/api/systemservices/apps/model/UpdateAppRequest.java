package com.connio.sdk.api.systemservices.apps.model;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import java.util.HashMap;
import java.util.Map;

import static com.connio.sdk.api.model.Method.PUT;
import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class UpdateAppRequest extends AppEndpointRequest {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(app, "App");

        Map<String, String> pathParams = new HashMap<String, String>();
        pathParams.put("appId", getAppId());

        metaData.setMethod(PUT);
        metaData.setPath("{appId}");
        metaData.setPathParams(pathParams);
        metaData.setRequestContent(app);
    }

    private String getAppId() {
        if (isNotEmpty(appName)) {
            return appName;
        } else if (isNotEmpty(appSid)) {
            return appSid;
        } else {
            throw new ConnioClientException("appName or appSid is required.");
        }
    }

    /**
     * TODO: javadoc
     */
    private App app;

    /**
     * TODO: javadoc
     */
    private String appName;

    /**
     * TODO: javadoc
     */
    private String appSid;

    public UpdateAppRequest() {
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppSid() {
        return appSid;
    }

    public void setAppSid(String appSid) {
        this.appSid = appSid;
    }
}

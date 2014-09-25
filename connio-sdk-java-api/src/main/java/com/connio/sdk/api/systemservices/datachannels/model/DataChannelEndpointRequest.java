package com.connio.sdk.api.systemservices.datachannels.model;

import com.connio.sdk.api.model.AbstractConnioRequest;
import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public abstract class DataChannelEndpointRequest<RS extends DataChannelEndpointResponse> extends AbstractConnioRequest<RS> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(appId, "AppName or AppSid");

        metaData.addPath("/_apps/{app-id}/_channels");
        metaData.addPathParam("app-id", appId);
    }

    /**
     * TODO: javadoc
     */
    private String appId;

    protected DataChannelEndpointRequest() {
    }

    protected DataChannelEndpointRequest(String appId) {
        this.appId = appId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}

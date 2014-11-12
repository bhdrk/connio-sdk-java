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
public abstract class DataChannelRequest<RS extends DataChannelResponse> extends AbstractConnioRequest<RS> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(appSidOrName, "AppName or AppSid");

        metaData.addPath("/_apps/{app}/_channels");
        metaData.addPathParam("app", appSidOrName);
    }

    /**
     * TODO: javadoc
     */
    private String appSidOrName;

    protected DataChannelRequest() {
    }

    protected DataChannelRequest(String appSidOrName) {
        this.appSidOrName = appSidOrName;
    }

    public String getAppSidOrName() {
        return appSidOrName;
    }

    public void setAppSidOrName(String appSidOrName) {
        this.appSidOrName = appSidOrName;
    }
}

package com.connio.sdk.api.systemservices.datachannels.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class GetAllDataChannelDetailsRequest extends DataChannelEndpointRequest {

    /**
     * TODO: javadoc
     */
    private String appSid;

    /**
     * TODO: javadoc
     */
    private String appName;

    public String getAppSid() {
        return appSid;
    }

    public void setAppSid(String appSid) {
        this.appSid = appSid;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}

package com.connio.sdk.api.systemservices.datachannels.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class GetDataChannelDetailsRequest extends DataChannelEndpointRequest {

    /**
     * TODO: javadoc
     */
    private String appSid;

    /**
     * TODO: javadoc
     */
    private String channelSid;

    /**
     * TODO: javadoc
     */
    private String appName;

    /**
     * TODO: javadoc
     */
    private String channelName;

    public String getAppSid() {
        return appSid;
    }

    public void setAppSid(String appSid) {
        this.appSid = appSid;
    }

    public String getChannelSid() {
        return channelSid;
    }

    public void setChannelSid(String channelSid) {
        this.channelSid = channelSid;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}

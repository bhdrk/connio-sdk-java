package com.connio.sdk.api.systemservices.datachannels.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.DELETE;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class DeleteDataChannelRequest extends DataChannelRequest<DeleteDataChannelResponse> {

    private String channelSidOrName;

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(channelSidOrName, "ChannelName or ChannelSid");

        metaData.setMethod(DELETE);
        metaData.addPath("/{channel}");
        metaData.addPathParam("channel", channelSidOrName);
    }

    public DeleteDataChannelRequest() {
        super();
    }

    public DeleteDataChannelRequest(String appId, String channelSidOrName) {
        super(appId);
        this.channelSidOrName = channelSidOrName;
    }

    public String getChannelSidOrName() {
        return channelSidOrName;
    }

    public void setChannelSidOrName(String channelSidOrName) {
        this.channelSidOrName = channelSidOrName;
    }
}

package com.connio.sdk.api.systemservices.datachannels.model;

import com.connio.sdk.api.model.RequestMetaData;

import static com.connio.sdk.api.model.Method.DELETE;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class DeleteDataChannelRequest extends DataChannelEndpointRequest<DeleteDataChannelResponse> {

    private String channelId;

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        metaData.setMethod(DELETE);
        metaData.addPath("/{channel-id}");
        metaData.addPathParam("channel-id", channelId);
    }

    public DeleteDataChannelRequest() {
        super();
    }

    public DeleteDataChannelRequest(String appId, String channelId) {
        super(appId);
        this.channelId = channelId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}

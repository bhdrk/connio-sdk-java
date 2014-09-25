package com.connio.sdk.api.systemservices.datachannels.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.PUT;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class UpdateDataChannelRequest extends DataChannelEndpointRequest<UpdateDataChannelResponse> {

    private String channelId;

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(channelId, "ChannelName or ChannelSid");
        Asserts.notNull(dataChannelUpdate, "DataChannel");

        metaData.setMethod(PUT);
        metaData.addPath("/{channel-id}");
        metaData.addPathParam("channel-id", channelId);
        metaData.setRequestContent(dataChannelUpdate);
    }

    private DataChannelUpdate dataChannelUpdate;

    public UpdateDataChannelRequest() {
        super();
    }

    public UpdateDataChannelRequest(String appId, String channelId, DataChannelUpdate dataChannelUpdate) {
        super(appId);
        this.channelId = channelId;
        this.dataChannelUpdate = dataChannelUpdate;
    }

    public DataChannelUpdate getDataChannelUpdate() {
        return dataChannelUpdate;
    }

    public void setDataChannelUpdate(DataChannelUpdate dataChannelUpdate) {
        this.dataChannelUpdate = dataChannelUpdate;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}

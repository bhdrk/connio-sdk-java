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
public class UpdateDataChannelRequest extends DataChannelRequest<UpdateDataChannelResponse> {

    private String channelSidOrName;

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(channelSidOrName, "ChannelName or ChannelSid");
        Asserts.notNull(dataChannelUpdate, "DataChannel");

        metaData.setMethod(PUT);
        metaData.addPath("/{channel}");
        metaData.addPathParam("channel", channelSidOrName);
        metaData.setRequestContent(dataChannelUpdate);
    }

    private DataChannelUpdate dataChannelUpdate;

    public UpdateDataChannelRequest() {
        super();
    }

    public UpdateDataChannelRequest(String appSidOrName, String channelSidOrName, DataChannelUpdate dataChannelUpdate) {
        super(appSidOrName);
        this.channelSidOrName = channelSidOrName;
        this.dataChannelUpdate = dataChannelUpdate;
    }

    public DataChannelUpdate getDataChannelUpdate() {
        return dataChannelUpdate;
    }

    public void setDataChannelUpdate(DataChannelUpdate dataChannelUpdate) {
        this.dataChannelUpdate = dataChannelUpdate;
    }

    public String getChannelSidOrName() {
        return channelSidOrName;
    }

    public void setChannelSidOrName(String channelSidOrName) {
        this.channelSidOrName = channelSidOrName;
    }
}

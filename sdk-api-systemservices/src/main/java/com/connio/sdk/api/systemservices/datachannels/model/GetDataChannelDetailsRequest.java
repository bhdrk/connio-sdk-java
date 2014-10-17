package com.connio.sdk.api.systemservices.datachannels.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class GetDataChannelDetailsRequest extends DataChannelEndpointRequest<GetDataChannelDetailsResponse> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(channelId, "ChannelName or ChannelSid");

        metaData.setMethod(GET);
        metaData.addPath("/{channel-id}");
        metaData.addPathParam("channel-id", channelId);
    }

    private String channelId;

    public GetDataChannelDetailsRequest() {
        super();
    }

    public GetDataChannelDetailsRequest(String appId, String channelId) {
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

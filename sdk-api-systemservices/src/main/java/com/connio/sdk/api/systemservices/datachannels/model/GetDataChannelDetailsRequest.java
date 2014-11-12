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
public class GetDataChannelDetailsRequest extends DataChannelRequest<GetDataChannelDetailsResponse> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(channelSidOrName, "ChannelName or ChannelSid");

        metaData.setMethod(GET);
        metaData.addPath("/{channel}");
        metaData.addPathParam("channel", channelSidOrName);
    }

    private String channelSidOrName;

    public GetDataChannelDetailsRequest() {
        super();
    }

    public GetDataChannelDetailsRequest(String appSidOrName, String channelSidOrName) {
        super(appSidOrName);
        this.channelSidOrName = channelSidOrName;
    }

    public String getChannelSidOrName() {
        return channelSidOrName;
    }

    public void setChannelSidOrName(String channelSidOrName) {
        this.channelSidOrName = channelSidOrName;
    }
}

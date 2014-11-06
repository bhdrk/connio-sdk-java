package com.connio.sdk.api.dataservices.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.POST;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 17.10.2014.
 */
public class SendDataToChannelRequest extends DataRequest<SendDataToChannelResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(appNameOrSid, "App Name Or App Sid");
        Asserts.notEmpty(channelNameOrSid, "Channel Name Or Channel Sid");
        Asserts.notNull(dataFeed, "Data Feed");

        metaData.setMethod(POST);
        metaData.addPath("/_apps/{app}/_data/{channel}");
        metaData.addPathParam("app", appNameOrSid);
        metaData.addPathParam("channel", channelNameOrSid);
        metaData.setRequestContent(dataFeed);

    }

    private String appNameOrSid;

    private String channelNameOrSid;

    private DataFeed dataFeed;

    public SendDataToChannelRequest() {
    }

    public SendDataToChannelRequest(String appNameOrSid, String channelNameOrSid, DataFeed dataFeed) {
        this.appNameOrSid = appNameOrSid;
        this.channelNameOrSid = channelNameOrSid;
        this.dataFeed = dataFeed;
    }

    public String getAppNameOrSid() {
        return appNameOrSid;
    }

    public void setAppNameOrSid(String appNameOrSid) {
        this.appNameOrSid = appNameOrSid;
    }

    public String getChannelNameOrSid() {
        return channelNameOrSid;
    }

    public void setChannelNameOrSid(String channelNameOrSid) {
        this.channelNameOrSid = channelNameOrSid;
    }

    public DataFeed getDataFeed() {
        return dataFeed;
    }

    public void setDataFeed(DataFeed dataFeed) {
        this.dataFeed = dataFeed;
    }
}

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

        Asserts.notEmpty(appSidOrName, "AppName Or AppSid");
        Asserts.notEmpty(channelNameOrSid, "ChannelName Or ChannelSid");
        Asserts.notNull(dataFeed, "Data Feed");

        metaData.setMethod(POST);
        metaData.addPath("/_apps/{app}/_data/{channel}");
        metaData.addPathParam("app", appSidOrName);
        metaData.addPathParam("channel", channelNameOrSid);
        metaData.setRequestContent(dataFeed);

    }

    private String appSidOrName;

    private String channelNameOrSid;

    private DataFeed dataFeed;

    public SendDataToChannelRequest() {
    }

    public SendDataToChannelRequest(String appSidOrName, String channelNameOrSid, DataFeed dataFeed) {
        this.appSidOrName = appSidOrName;
        this.channelNameOrSid = channelNameOrSid;
        this.dataFeed = dataFeed;
    }

    public String getAppSidOrName() {
        return appSidOrName;
    }

    public void setAppSidOrName(String appSidOrName) {
        this.appSidOrName = appSidOrName;
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

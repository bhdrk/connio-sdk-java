package com.connio.sdk.api.dataservices.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.GET;
import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 20.10.2014.
 */
public class GetDataFromChannelRequest extends DataEndpointRequest<GetDataFromChannelResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(appNameOrSid, "App Name Or App Sid");
        Asserts.notEmpty(channelNameOrSid, "Channel Name Or Channel Sid");

        metaData.setMethod(GET);
        metaData.addPath("/_apps/{app}/_data/{channel}");
        metaData.addPathParam("app", appNameOrSid);
        metaData.addPathParam("channel", channelNameOrSid);
        metaData.addQueryParam("query", isNotEmpty(dataQuery.getQuery()) ? dataQuery.getQuery() : "");

        if (dataQuery.getSkip() != null) {
            metaData.addQueryParam("skip", Integer.toString(dataQuery.getSkip()));
        }

        if (dataQuery.getLimit() != null) {
            metaData.addQueryParam("limit", Integer.toString(dataQuery.getLimit()));
        }

        if (isNotEmpty(dataQuery.getBookmark())) {
            metaData.addQueryParam("bookmark", dataQuery.getBookmark());
        }

        if (isNotEmpty(dataQuery.getSort())) {
            metaData.addQueryParam("sort", dataQuery.getSort());
        }
    }

    private String appNameOrSid;

    private String channelNameOrSid;

    private DataQuery dataQuery;

    public GetDataFromChannelRequest() {
    }

    public GetDataFromChannelRequest(String appNameOrSid, String channelNameOrSid, DataQuery dataQuery) {
        this.appNameOrSid = appNameOrSid;
        this.channelNameOrSid = channelNameOrSid;
        this.dataQuery = dataQuery;
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
}

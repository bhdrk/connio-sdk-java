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
public class GetDataFromChannelRequest extends DataRequest<GetDataFromChannelResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(appSidOrName, "AppName Or AppSid");
        Asserts.notEmpty(channelSidOrName, "ChannelName Or ChannelSid");

        metaData.setMethod(GET);
        metaData.addPath("/_apps/{app}/_data/{channel}");
        metaData.addPathParam("app", appSidOrName);
        metaData.addPathParam("channel", channelSidOrName);
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

    private String appSidOrName;

    private String channelSidOrName;

    private DataQuery dataQuery;

    public GetDataFromChannelRequest() {
    }

    public GetDataFromChannelRequest(String appSidOrName, String channelSidOrName, DataQuery dataQuery) {
        this.appSidOrName = appSidOrName;
        this.channelSidOrName = channelSidOrName;
        this.dataQuery = dataQuery;
    }

    public String getAppSidOrName() {
        return appSidOrName;
    }

    public void setAppSidOrName(String appSidOrName) {
        this.appSidOrName = appSidOrName;
    }

    public String getChannelSidOrName() {
        return channelSidOrName;
    }

    public void setChannelSidOrName(String channelSidOrName) {
        this.channelSidOrName = channelSidOrName;
    }
}

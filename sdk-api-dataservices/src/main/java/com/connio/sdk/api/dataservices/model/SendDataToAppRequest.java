package com.connio.sdk.api.dataservices.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.POST;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 17.10.2014.
 */
public class SendDataToAppRequest extends DataRequest<SendDataToAppResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(appNameOrSid, "App Name Or App Sid");
        Asserts.notNull(dataFeed, "Data Feed");

        metaData.setMethod(POST);
        metaData.addPath("/_apps/{app}/_data");
        metaData.addPathParam("app", appNameOrSid);
        metaData.setRequestContent(dataFeed);
    }

    private String appNameOrSid;

    private DataFeed dataFeed;

    public SendDataToAppRequest() {
    }

    public SendDataToAppRequest(String appNameOrSid, DataFeed dataFeed) {
        this.appNameOrSid = appNameOrSid;
        this.dataFeed = dataFeed;
    }

    public String getAppNameOrSid() {
        return appNameOrSid;
    }

    public void setAppNameOrSid(String appNameOrSid) {
        this.appNameOrSid = appNameOrSid;
    }

    public DataFeed getDataFeed() {
        return dataFeed;
    }

    public void setDataFeed(DataFeed dataFeed) {
        this.dataFeed = dataFeed;
    }
}

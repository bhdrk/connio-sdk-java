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

        Asserts.notEmpty(appSidOrName, "AppName Or AppSid");
        Asserts.notNull(dataFeed, "Data Feed");

        metaData.setMethod(POST);
        metaData.addPath("/_apps/{app}/_data");
        metaData.addPathParam("app", appSidOrName);
        metaData.setRequestContent(dataFeed);
    }

    private String appSidOrName;

    private DataFeed dataFeed;

    public SendDataToAppRequest() {
    }

    public SendDataToAppRequest(String appSidOrName, DataFeed dataFeed) {
        this.appSidOrName = appSidOrName;
        this.dataFeed = dataFeed;
    }

    public String getAppSidOrName() {
        return appSidOrName;
    }

    public void setAppSidOrName(String appSidOrName) {
        this.appSidOrName = appSidOrName;
    }

    public DataFeed getDataFeed() {
        return dataFeed;
    }

    public void setDataFeed(DataFeed dataFeed) {
        this.dataFeed = dataFeed;
    }
}

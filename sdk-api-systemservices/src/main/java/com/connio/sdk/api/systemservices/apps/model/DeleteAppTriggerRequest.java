package com.connio.sdk.api.systemservices.apps.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.DELETE;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 14.11.2014.
 */
public class DeleteAppTriggerRequest extends AppRequest<DeleteAppTriggerResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(appSidOrName, "AppName or AppSid");
        Asserts.notNull(triggerSid, "TriggerSid");

        metaData.setMethod(DELETE);
        metaData.addPath("/{app}/_triggers/{trigger-sid}");
        metaData.addPathParam("app", appSidOrName);
        metaData.addPathParam("trigger-sid", triggerSid);
    }

    private String appSidOrName;

    private String triggerSid;

    public DeleteAppTriggerRequest() {
    }

    public DeleteAppTriggerRequest(String appSidOrName, String triggerSid) {
        this.appSidOrName = appSidOrName;
        this.triggerSid = triggerSid;
    }

    public String getAppSidOrName() {
        return appSidOrName;
    }

    public void setAppSidOrName(String appSidOrName) {
        this.appSidOrName = appSidOrName;
    }

    public String getTriggerSid() {
        return triggerSid;
    }

    public void setTriggerSid(String triggerSid) {
        this.triggerSid = triggerSid;
    }
}

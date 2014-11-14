package com.connio.sdk.api.systemservices.apps.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.POST;

/**
 * Created by bdirik on 14.11.2014.
 */
public class CreateAppTriggerRequest extends AppRequest<CreateAppTriggerResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(appSidOrName, "AppName or AppSid");
        Asserts.notNull(trigger, "Trigger");

        metaData.setMethod(POST);
        metaData.addPath("/{app}/_triggers");
        metaData.addPathParam("app", appSidOrName);
        metaData.setRequestContent(trigger);
    }

    private String appSidOrName;

    private Trigger trigger;

    public CreateAppTriggerRequest() {
    }

    public CreateAppTriggerRequest(String appSidOrName, Trigger trigger) {
        this.appSidOrName = appSidOrName;
        this.trigger = trigger;
    }

    public String getAppSidOrName() {
        return appSidOrName;
    }

    public void setAppSidOrName(String appSidOrName) {
        this.appSidOrName = appSidOrName;
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }
}

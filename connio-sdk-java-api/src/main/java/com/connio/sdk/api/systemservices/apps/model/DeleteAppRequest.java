package com.connio.sdk.api.systemservices.apps.model;

import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.model.RequestMetaData;

import java.util.HashMap;
import java.util.Map;

import static com.connio.sdk.api.model.Method.DELETE;
import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class DeleteAppRequest extends AppEndpointRequest {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Map<String, String> pathParams = new HashMap<String, String>();
        pathParams.put("app", getAppId());

        metaData.setMethod(DELETE);
        metaData.setPath("{app}");
        metaData.setPathParams(pathParams);
    }

    private String getAppId() {
        if (isNotEmpty(appName)) {
            return appName;
        } else if (isNotEmpty(appSid)) {
            return appSid;
        } else {
            throw new ConnioClientException("appName or appSid is required.");
        }
    }

    private String appSid;

    private String appName;

    public DeleteAppRequest() {
    }

    public String getAppSid() {
        return appSid;
    }

    public void setAppSid(String appSid) {
        this.appSid = appSid;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}

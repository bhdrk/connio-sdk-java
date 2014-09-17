package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;

import java.util.HashMap;
import java.util.Map;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class GetSubAccountDetailsRequest extends AccountEndpointRequest {
    @Override
    public RequestMetaData getRequestMetaData() {
        Map<String, String> pathParams = new HashMap<String, String>(1);
        pathParams.put("account-sid", getSid());

        RequestMetaData data = super.getRequestMetaData();
        data.setPath("/{account-sid}");
        data.setPathParams(pathParams);
        data.setMethod(GET);

        return data;
    }

    /**
     * TODO: javadoc
     */
    private String sid;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}

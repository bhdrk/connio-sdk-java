package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;

import java.util.HashMap;
import java.util.Map;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class GetBillingInfoRequest extends AccountEndpointRequest {

    @Override
    public RequestMetaData getRequestMetaData() {
        Map<String, String> pathParams = new HashMap<String, String>(1);
        pathParams.put("account-sid", getSid());

        RequestMetaData data = super.getRequestMetaData();
        data.setMethod(GET);
        data.setPath("{account-sid}/_billinginfo");
        data.setPathParams(pathParams);

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

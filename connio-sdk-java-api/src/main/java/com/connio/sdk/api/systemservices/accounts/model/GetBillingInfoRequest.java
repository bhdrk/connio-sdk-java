package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import java.util.HashMap;
import java.util.Map;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class GetBillingInfoRequest extends AccountEndpointRequest<Sid> {

    @Override
    protected void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(sid, "Sid");

        Map<String, String> pathParams = new HashMap<String, String>(1);
        pathParams.put("account-sid", sid);

        metaData.setMethod(GET);
        metaData.setPath("{account-sid}/_billinginfo");
        metaData.setPathParams(pathParams);
    }

    /**
     * TODO: javadoc
     */
    private String sid;

    public GetBillingInfoRequest() {
    }

    public GetBillingInfoRequest(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}

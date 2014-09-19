package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import java.util.HashMap;
import java.util.Map;

import static com.connio.sdk.api.model.Method.DELETE;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class DeleteSubAccountRequest extends AccountEndpointRequest<Sid> {

    @Override
    protected void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(sid, "Sid");

        Map<String, String> pathParams = new HashMap<String, String>(1);
        pathParams.put("account-sid", sid);

        metaData.setMethod(DELETE);
        metaData.setPath("{account-sid}");
        metaData.setPathParams(pathParams);
    }

    /**
     * TODO: javadoc
     */
    private String sid;

    public DeleteSubAccountRequest() {
    }

    public DeleteSubAccountRequest(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}

package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import java.util.HashMap;
import java.util.Map;

import static com.connio.sdk.api.model.Method.PUT;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class UpdateSubAccountRequest extends AccountEndpointRequest<SubAccount> {

    @Override
    protected void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(content, "Content");
        Asserts.notNull(sid, "Sid");
        Asserts.notEmpty(sid.getSid(), "Sid");

        Map<String, String> pathParams = new HashMap<String, String>(1);
        pathParams.put("account-sid", sid.getSid());

        metaData.setMethod(PUT);
        metaData.setPath("{account-sid}");
        metaData.setPathParams(pathParams);
    }

    /**
     * TODO: javadoc
     */
    private Sid sid;

    /**
     * TODO: javadoc
     */
    private SubAccount content;

    public UpdateSubAccountRequest(Sid sid, SubAccount content) {
        this.sid = sid;
        this.content = content;
    }

    @Override
    public Class<SubAccount> getContentType() {
        return SubAccount.class;
    }

    @Override
    public SubAccount getContent() {
        return content;
    }
}

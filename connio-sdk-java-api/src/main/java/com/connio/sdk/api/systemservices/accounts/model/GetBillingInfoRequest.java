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

        Asserts.notNull(content, "Content");
        Asserts.notEmpty(content.getSid(), "Sid");

        Map<String, String> pathParams = new HashMap<String, String>(1);
        pathParams.put("account-sid", content.getSid());

        metaData.setMethod(GET);
        metaData.setPath("{account-sid}/_billinginfo");
        metaData.setPathParams(pathParams);
    }

    private Sid content;

    public GetBillingInfoRequest(Sid content) {
        this.content = content;
    }

    @Override
    public Class<Sid> getContentType() {
        return Sid.class;
    }

    @Override
    public Sid getContent() {
        return content;
    }
}

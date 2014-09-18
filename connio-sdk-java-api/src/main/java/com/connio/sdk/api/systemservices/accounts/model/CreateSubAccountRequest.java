package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.RequestMetaData;

import static com.connio.sdk.api.model.Method.POST;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class CreateSubAccountRequest extends AccountEndpointRequest<SubAccount> {

    @Override
    protected void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);
        metaData.setMethod(POST);
    }

    private SubAccount content;

    public CreateSubAccountRequest(SubAccount content) {
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

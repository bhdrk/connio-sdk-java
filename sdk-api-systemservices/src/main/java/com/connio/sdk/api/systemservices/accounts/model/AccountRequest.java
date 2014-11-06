package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.AbstractConnioRequest;
import com.connio.sdk.api.model.RequestMetaData;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public abstract class AccountRequest<RS extends AccountResponse> extends AbstractConnioRequest<RS> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);
        metaData.addPath("/_accounts");
    }
}

package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.AbstractConnioRequest;
import com.connio.sdk.api.model.RequestMetaData;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public abstract class AccountEndpointRequest<T> extends AbstractConnioRequest<T> {
    @Override
    protected void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);
        metaData.setEndpoint("_accounts");
    }
}

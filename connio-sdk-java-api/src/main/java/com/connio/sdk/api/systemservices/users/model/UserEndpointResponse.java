package com.connio.sdk.api.systemservices.users.model;

import com.connio.sdk.api.model.AbstractConnioResponse;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public abstract class UserEndpointResponse extends AbstractConnioResponse {
    @Override
    public Class getResultType() {
        return null;
    }

    @Override
    public Object getResult() {
        return null;
    }

    @Override
    public void setResult(Object result) {

    }
}

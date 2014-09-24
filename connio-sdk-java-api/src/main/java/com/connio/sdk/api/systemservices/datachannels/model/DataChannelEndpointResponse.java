package com.connio.sdk.api.systemservices.datachannels.model;

import com.connio.sdk.api.model.AbstractConnioResponse;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public abstract class DataChannelEndpointResponse extends AbstractConnioResponse {
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

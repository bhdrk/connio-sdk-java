package com.connio.sdk.api.systemservices.apps.model;

import com.connio.sdk.api.model.Deleted;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class DeleteAppResponse extends AppEndpointResponse<Deleted> {

    private Deleted result;

    @Override
    public Class<Deleted> getResultType() {
        return Deleted.class;
    }

    @Override
    public Deleted getResult() {
        return result;
    }

    @Override
    public void setResult(Deleted result) {
        this.result = result;
    }
}

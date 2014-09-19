package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class DeleteSubAccountResponse extends AccountEndpointResponse<Deleted> {

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

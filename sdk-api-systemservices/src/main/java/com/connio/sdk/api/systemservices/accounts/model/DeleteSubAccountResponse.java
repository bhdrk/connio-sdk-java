package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.model.Deleted;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class DeleteSubAccountResponse extends AccountResponse<Deleted> {

    private Deleted result;

    @Override
    public Deleted getResult() {
        return result;
    }

    @Override
    public void setResult(Deleted result) {
        this.result = result;
    }
}

package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class UpdateSubAccountResponse extends AccountResponse<SubAccountDetails> {

    /**
     * TODO: javadoc
     */
    private SubAccountDetails result;

    public UpdateSubAccountResponse() {
    }

    @Override
    public SubAccountDetails getResult() {
        return result;
    }

    @Override
    public void setResult(SubAccountDetails result) {
        this.result = result;
    }
}

package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class GetSubAccountDetailsResponse extends AccountResponse<SubAccountDetails> {

    /**
     * TODO: javadoc
     */
    private SubAccountDetails result;

    public GetSubAccountDetailsResponse() {
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

package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class GetSubAccountDetailsResponse extends AccountEndpointResponse<SubAccountDetails> {

    /**
     * TODO: javadoc
     */
    private SubAccountDetails result;

    @Override
    public Class<SubAccountDetails> getResultType() {
        return SubAccountDetails.class;
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

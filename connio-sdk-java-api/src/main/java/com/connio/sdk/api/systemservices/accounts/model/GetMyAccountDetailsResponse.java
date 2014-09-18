package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class GetMyAccountDetailsResponse extends AccountEndpointResponse<AccountDetails> {

    private AccountDetails result;

    @Override
    public Class<AccountDetails> getResultType() {
        return AccountDetails.class;
    }

    @Override
    public AccountDetails getResult() {
        return result;
    }

    @Override
    public void setResult(AccountDetails result) {
        this.result = result;
    }
}

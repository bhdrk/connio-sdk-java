package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class GetMyAccountDetailsResponse extends AccountResponse<AccountDetails> {

    private AccountDetails result;

    public GetMyAccountDetailsResponse() {
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

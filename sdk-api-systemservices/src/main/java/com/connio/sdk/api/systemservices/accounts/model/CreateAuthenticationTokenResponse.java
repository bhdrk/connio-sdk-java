package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class CreateAuthenticationTokenResponse extends AccountResponse<AuthToken> {

    private AuthToken result;

    public CreateAuthenticationTokenResponse() {
    }

    @Override
    public AuthToken getResult() {
        return result;
    }

    @Override
    public void setResult(AuthToken result) {
        this.result = result;
    }
}

package com.connio.sdk.api.systemservices.users.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class CreateUserResponse extends UserEndpointResponse<UserDetails> {

    /**
     * TODO: javadoc
     */
    private UserDetails result;

    @Override
    public Class<UserDetails> getResultType() {
        return UserDetails.class;
    }

    @Override
    public void setResult(UserDetails result) {
        this.result = result;
    }

    @Override
    public UserDetails getResult() {
        return result;
    }

}

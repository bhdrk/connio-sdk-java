package com.connio.sdk.api.systemservices.users.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class GetAllUserDetailsResponse extends UserEndpointResponse<UserResultSet> {

    /**
     * TODO: javadoc
     */
    private UserResultSet result;

    @Override
    public Class<UserResultSet> getResultType() {
        return UserResultSet.class;
    }

    @Override
    public UserResultSet getResult() {
        return result;
    }

    @Override
    public void setResult(UserResultSet result) {
        this.result = result;
    }
}

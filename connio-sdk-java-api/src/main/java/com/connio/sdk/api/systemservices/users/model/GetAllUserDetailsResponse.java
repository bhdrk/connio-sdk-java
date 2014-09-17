package com.connio.sdk.api.systemservices.users.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class GetAllUserDetailsResponse extends UserEndpointResponse {

    /**
     * TODO: javadoc
     */
    private UserResultSet userResultSet;

    public UserResultSet getUserResultSet() {
        return userResultSet;
    }

    public void setUserResultSet(UserResultSet userResultSet) {
        this.userResultSet = userResultSet;
    }
}

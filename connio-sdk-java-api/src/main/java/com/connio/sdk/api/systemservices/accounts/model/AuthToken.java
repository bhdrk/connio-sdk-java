package com.connio.sdk.api.systemservices.accounts.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 19.09.2014
 */
public class AuthToken implements Serializable {
    /**
     * TODO: javadoc
     */
    private String authToken;

    public AuthToken() {
    }

    public AuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthToken authToken1 = (AuthToken) o;

        if (authToken != null ? !authToken.equals(authToken1.authToken) : authToken1.authToken != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return authToken != null ? authToken.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AuthToken{" +
                "authToken='" + authToken + '\'' +
                '}';
    }
}

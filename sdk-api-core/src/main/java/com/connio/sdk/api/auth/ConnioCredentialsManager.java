package com.connio.sdk.api.auth;

import com.connio.sdk.api.auth.provider.ConnioCredentialsProviderChain;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 18.09.2014
 */
public class ConnioCredentialsManager {

    private static ConnioCredentialsProviderChain providerChain = new ConnioCredentialsProviderChain();

    /**
     * TODO: javadoc
     *
     * @param credentials
     */
    public static void setCredentials(ConnioCredentials credentials) {
        providerChain.setCredentials(credentials);
    }

    /**
     * TODO: javadoc
     *
     * @return
     */
    public static ConnioCredentials getCredentials() {
        return providerChain.getCredentials();
    }
}

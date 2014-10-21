package com.connio.sdk.api.auth;

import com.connio.sdk.api.auth.provider.ConnioCredentialsProviderChain;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.utils.Asserts;

import java.util.Locale;

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
    public static void addCredentials(ConnioCredentials credentials) {
        providerChain.addCredentials(credentials);
    }

    /**
     * TODO: javadoc
     *
     * @return
     */
    public static ConnioCredentials getCredentials(String profileName) {
        Asserts.notEmpty(profileName, "ProfileName");

        ConnioCredentials credentials = providerChain.getCredentials(profileName.toLowerCase(Locale.ENGLISH));

        if (credentials == null) {
            throw new ConnioClientException("Credentials does not exists for profile: " + profileName);
        }

        return credentials;
    }
}

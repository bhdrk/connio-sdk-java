package com.connio.sdk.api.auth.provider;

import com.connio.sdk.api.auth.ConnioCredentials;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 18.09.2014
 */
public class ConnioCredentialsProviderChain implements ConnioCredentialsProvider {

    private ConnioCredentials credentials;

    private ConnioCredentialsProvider[] providers;

    public ConnioCredentialsProviderChain() {
        /**
         * TODO: Add more provider support
         */
        this(new ProfileCredentialsProvider());
    }

    private ConnioCredentialsProviderChain(ConnioCredentialsProvider... providers) {
        this.providers = providers;
        load();
    }

    private void load() {
        for (ConnioCredentialsProvider provider : providers) {
            ConnioCredentials credentials = provider.getCredentials();
            if (credentials != null) {
                this.credentials = credentials;
                break;
            }
        }
    }

    @Override
    public ConnioCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(ConnioCredentials credentials) {
        this.credentials = credentials;
    }
}

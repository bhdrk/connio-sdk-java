package com.connio.sdk.api.auth.provider;

import com.connio.sdk.api.auth.ConnioCredentials;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 18.09.2014
 */
public class ConnioCredentialsProviderChain implements ConnioCredentialsProvider {

    private ConnioCredentials credentials;

    private List<ConnioCredentialsProvider> providers;

    public ConnioCredentialsProviderChain() {
        providers = new ArrayList<ConnioCredentialsProvider>(3);

        providers.add(new EnvironmentVariablesCredentialsProvider());
        providers.add(new SystemPropertyCredentialsProvider());
        providers.add(new ProfileCredentialsProvider());

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

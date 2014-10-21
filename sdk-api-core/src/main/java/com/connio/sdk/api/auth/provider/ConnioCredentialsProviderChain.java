package com.connio.sdk.api.auth.provider;

import com.connio.sdk.api.auth.ConnioCredentials;

import java.util.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 18.09.2014
 */
public class ConnioCredentialsProviderChain implements ConnioCredentialsProvider {

    private List<ConnioCredentialsProvider> providers;

    private Map<String, ConnioCredentials> credentialsMap;

    public ConnioCredentialsProviderChain() {
        providers = new ArrayList<ConnioCredentialsProvider>(3);
        providers.add(new EnvironmentVariablesCredentialsProvider());
        providers.add(new SystemPropertyCredentialsProvider());
        providers.add(new ProfileCredentialsProvider());

        getCredentialsMap();
    }

    @Override
    public Map<String, ConnioCredentials> getCredentialsMap() {
        if (credentialsMap == null) {
            credentialsMap = new HashMap<String, ConnioCredentials>();
            for (ConnioCredentialsProvider provider : providers) {
                Map<String, ConnioCredentials> cmap = provider.getCredentialsMap();
                if (cmap != null) {
                    credentialsMap.putAll(cmap);
                }
            }
        }
        return credentialsMap;
    }

    public ConnioCredentials getCredentials(String profileName) {
        return credentialsMap.get(profileName);
    }

    public void addCredentials(ConnioCredentials credentials) {
        credentialsMap.put(credentials.getProfile().toLowerCase(Locale.ENGLISH), credentials);
    }
}

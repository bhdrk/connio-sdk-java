package com.connio.sdk.api.auth.provider;

import com.connio.sdk.api.auth.ConnioCredentials;

import java.util.Map;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 19.09.2014
 */
public class EnvironmentVariablesCredentialsProvider extends AbstractConnioCredentialsProvider {

    public static final String AUTH_PREFIX = "CONNIO_AUTH_";
    public static final String ACCESSKEY_SUFFIX = "_ACCESSKEY";
    public static final String SECRETKEY_SUFFIX = "_SECRETKEY";

    public EnvironmentVariablesCredentialsProvider() {
        super(AUTH_PREFIX, ACCESSKEY_SUFFIX, SECRETKEY_SUFFIX);
    }

    @Override
    public Map<String, ConnioCredentials> getCredentialsMap() {
        return getCredentialsMap(System.getenv());
    }

}

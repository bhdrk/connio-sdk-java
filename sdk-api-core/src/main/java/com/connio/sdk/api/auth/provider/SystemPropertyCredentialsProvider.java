package com.connio.sdk.api.auth.provider;

import com.connio.sdk.api.auth.ConnioCredentials;

import java.util.Map;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 19.09.2014
 */
public class SystemPropertyCredentialsProvider extends AbstractConnioCredentialsProvider {

    public static final String AUTH_PREFIX = "connio.auth.";
    public static final String ACCESSKEY_SUFFIX = ".accessKey";
    public static final String SECRETKEY_SUFFIX = ".secretKey";

    protected SystemPropertyCredentialsProvider() {
        super(AUTH_PREFIX, ACCESSKEY_SUFFIX, SECRETKEY_SUFFIX);
    }

    @Override
    public Map<String, ConnioCredentials> getCredentialsMap() {
        Map<String, String> systemPropertyMap = toMap(System.getProperties());
        return getCredentialsMap(systemPropertyMap);
    }
}

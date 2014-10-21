package com.connio.sdk.api.auth.provider;

import com.connio.sdk.api.auth.ConnioCredentials;

import java.util.Map;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 18.09.2014
 */
public interface ConnioCredentialsProvider {

    /**
     * TODO: javadoc
     *
     * @return
     */
    public Map<String, ConnioCredentials> getCredentialsMap();
}

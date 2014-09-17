package com.connio.sdk.http.model;

import com.connio.sdk.api.exception.ConnioClientException;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 15.09.2014
 */
public enum Protocol {
    HTTP, HTTPS;

    public static Protocol fromValue(String str) {
        for (Protocol protocol : values()) {
            if (protocol.name().equalsIgnoreCase(str)) {
                return protocol;
            }
        }
        throw new ConnioClientException("Protocol not found for " + str);
    }
}

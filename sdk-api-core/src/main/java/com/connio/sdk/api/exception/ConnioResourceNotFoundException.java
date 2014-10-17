package com.connio.sdk.api.exception;

import java.util.List;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 08.10.2014
 */
public class ConnioResourceNotFoundException extends ConnioServiceException {
    public ConnioResourceNotFoundException(String status, String causeMessage, List<String> details, String responseStatus, Integer responseCode) {
        super(status, causeMessage, details, responseStatus, responseCode);
    }
}

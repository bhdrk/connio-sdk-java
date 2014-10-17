package com.connio.sdk.api.exception;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class ConnioClientException extends ConnioException {

    /**
     * {@inheritDoc}
     *
     * @param message
     */
    public ConnioClientException(String message) {
        super(message);
    }

    /**
     * {@inheritDoc}
     *
     * @param message
     * @param cause
     */
    public ConnioClientException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * {@inheritDoc}
     *
     * @param cause
     */
    public ConnioClientException(Throwable cause) {
        super(cause);
    }
}

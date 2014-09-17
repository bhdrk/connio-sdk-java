package com.connio.sdk.api.exception;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class ConnioEndpointException extends ConnioException {

    /**
     * {@inheritDoc}
     *
     * @param message
     */
    public ConnioEndpointException(String message) {
        super(message);
    }

    /**
     * {@inheritDoc}
     *
     * @param message
     * @param cause
     */
    public ConnioEndpointException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * {@inheritDoc}
     *
     * @param cause
     */
    public ConnioEndpointException(Throwable cause) {
        super(cause);
    }
}

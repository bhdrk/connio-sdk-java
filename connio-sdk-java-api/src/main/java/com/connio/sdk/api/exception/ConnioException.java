package com.connio.sdk.api.exception;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class ConnioException extends RuntimeException {

    /**
     * TODO: javadoc
     *
     * @param message
     */
    public ConnioException(String message) {
        super(message);
    }

    /**
     * TODO: javadoc
     *
     * @param message
     * @param cause
     */
    public ConnioException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * TODO: javadoc
     *
     * @param cause
     */
    public ConnioException(Throwable cause) {
        super(cause);
    }
}

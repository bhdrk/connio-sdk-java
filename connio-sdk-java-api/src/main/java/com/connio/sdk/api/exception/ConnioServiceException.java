package com.connio.sdk.api.exception;

import java.util.List;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class ConnioServiceException extends ConnioException {

    private String status;

    private String message;

    private String causeMessage;

    private List<String> details;

    private String responseStatus;

    public ConnioServiceException(String status, String message, String causeMessage, List<String> details, String responseStatus) {
        super(message);
        this.status = status;
        this.message = message;
        this.causeMessage = causeMessage;
        this.details = details;
        this.responseStatus = responseStatus;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getDetails() {
        return details;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public String getCauseMessage() {
        return causeMessage;
    }
}

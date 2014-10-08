package com.connio.sdk.api.exception;

import java.util.List;

import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class ConnioServiceException extends ConnioException {

    private String status;

    private String causeMessage;

    private List<String> details;

    private String responseStatus;

    private int responseCode;

    public ConnioServiceException(String status, String causeMessage, List<String> details, String responseStatus, Integer responseCode) {
        super(responseCode + ":" + causeMessage + (isNotEmpty(details) ? details : ""));
        this.status = status;
        this.causeMessage = causeMessage;
        this.details = details;
        this.responseStatus = responseStatus;
        this.responseCode = responseCode;
    }

    public String getStatus() {
        return status;
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

    public int getResponseCode() {
        return responseCode;
    }

    @Override
    public String toString() {
        return "ConnioServiceException{" +
                "status='" + status + '\'' +
                ", causeMessage='" + causeMessage + '\'' +
                ", details=" + details +
                ", responseStatus='" + responseStatus + '\'' +
                ", responseCode=" + responseCode +
                '}';
    }
}

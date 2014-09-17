package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class GetSubAccountDetailsResponse extends AccountEndpointResponse {

    /**
     * TODO: javadoc
     */
    private SubAccountDetails subAccountDetails;

    public SubAccountDetails getSubAccountDetails() {
        return subAccountDetails;
    }

    public void setSubAccountDetails(SubAccountDetails subAccountDetails) {
        this.subAccountDetails = subAccountDetails;
    }
}

package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class CreateSubAccountResponse extends AccountEndpointResponse {

    /**
     * TODO: javadoc
     */
    private SubAccountDetails createdSubAccountDetails;

    public SubAccountDetails getCreatedSubAccountDetails() {
        return createdSubAccountDetails;
    }

    public void setCreatedSubAccountDetails(SubAccountDetails createdSubAccountDetails) {
        this.createdSubAccountDetails = createdSubAccountDetails;
    }
}

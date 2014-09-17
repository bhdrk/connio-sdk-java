package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class UpdateSubAccountResponse extends AccountEndpointResponse {

    /**
     * TODO: javadoc
     */
    private SubAccountDetails updatedSubAccountDetails;

    public SubAccountDetails getUpdatedSubAccountDetails() {
        return updatedSubAccountDetails;
    }

    public void setUpdatedSubAccountDetails(SubAccountDetails updatedSubAccountDetails) {
        this.updatedSubAccountDetails = updatedSubAccountDetails;
    }
}

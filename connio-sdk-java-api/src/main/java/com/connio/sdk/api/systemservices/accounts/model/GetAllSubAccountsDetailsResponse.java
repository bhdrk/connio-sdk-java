package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class GetAllSubAccountsDetailsResponse extends AccountEndpointResponse {

    /**
     * TODO: javadoc
     */
    private SubAccountResultSet subAccountResultSet;

    public SubAccountResultSet getSubAccountResultSet() {
        return subAccountResultSet;
    }

    public void setSubAccountResultSet(SubAccountResultSet subAccountResultSet) {
        this.subAccountResultSet = subAccountResultSet;
    }
}

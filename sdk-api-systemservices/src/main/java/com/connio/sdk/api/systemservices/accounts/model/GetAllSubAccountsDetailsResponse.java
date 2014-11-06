package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class GetAllSubAccountsDetailsResponse extends AccountResponse<SubAccountResultSet> {

    /**
     * TODO: javadoc
     */
    private SubAccountResultSet result;

    public GetAllSubAccountsDetailsResponse() {
    }

    @Override
    public SubAccountResultSet getResult() {
        return result;
    }

    @Override
    public void setResult(SubAccountResultSet result) {
        this.result = result;
    }
}

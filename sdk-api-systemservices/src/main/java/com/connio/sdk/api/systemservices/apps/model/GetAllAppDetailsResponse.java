package com.connio.sdk.api.systemservices.apps.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class GetAllAppDetailsResponse extends AppResponse<AppResultSet> {

    /**
     * TODO: javadoc
     */
    private AppResultSet result;

    @Override
    public AppResultSet getResult() {
        return result;
    }

    @Override
    public void setResult(AppResultSet result) {
        this.result = result;
    }
}

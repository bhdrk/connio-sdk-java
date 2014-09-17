package com.connio.sdk.api.systemservices.apps.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class GetAllAppDetailsResponse extends AppEndpointResponse {

    /**
     * TODO: javadoc
     */
    private AppResultSet appResultSet;

    public AppResultSet getAppResultSet() {
        return appResultSet;
    }

    public void setAppResultSet(AppResultSet appResultSet) {
        this.appResultSet = appResultSet;
    }
}

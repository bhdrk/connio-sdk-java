package com.connio.sdk.api.systemservices.apps.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class CreateAppResponse extends AppEndpointResponse<AppDetails> {

    /**
     * TODO: javadoc
     */
    private AppDetails result;

    @Override
    public AppDetails getResult() {
        return result;
    }

    @Override
    public void setResult(AppDetails result) {
        this.result = result;
    }
}

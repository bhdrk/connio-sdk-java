package com.connio.sdk.api.systemservices.accounts.model;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class GetBillingInfoResponse extends AccountEndpointResponse<BillingInfoList> {

    private BillingInfoList result;

    @Override
    public BillingInfoList getResult() {
        return result;
    }

    @Override
    public void setResult(BillingInfoList result) {
        this.result = result;
    }
}

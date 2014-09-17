package com.connio.sdk.api.systemservices.accounts.model;

import java.util.List;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public class GetBillingInfoResponse extends AccountEndpointResponse {

    /**
     * TODO: javadoc
     */
    private List<BillingInfo> billingInfo;

    public List<BillingInfo> getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(List<BillingInfo> billingInfo) {
        this.billingInfo = billingInfo;
    }
}

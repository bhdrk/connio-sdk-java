package com.connio.sdk.api.systemservices.accounts.model;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 19.09.2014
 */
public class BillingInfoList implements Serializable {
    /**
     * TODO: javadoc
     */
    private List<BillingInfo> billingInfo;

    public BillingInfoList() {
    }

    public BillingInfoList(List<BillingInfo> billingInfo) {
        this.billingInfo = billingInfo;
    }

    public List<BillingInfo> getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(List<BillingInfo> billingInfo) {
        this.billingInfo = billingInfo;
    }
}

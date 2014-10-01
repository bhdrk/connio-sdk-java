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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingInfoList that = (BillingInfoList) o;

        if (billingInfo != null ? !billingInfo.equals(that.billingInfo) : that.billingInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return billingInfo != null ? billingInfo.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BillingInfoList{" +
                "billingInfo=" + billingInfo +
                '}';
    }
}

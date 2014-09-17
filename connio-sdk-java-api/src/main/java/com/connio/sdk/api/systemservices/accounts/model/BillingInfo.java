package com.connio.sdk.api.systemservices.accounts.model;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class BillingInfo implements Serializable {

    /**
     * TODO: javadoc
     */
    private Date date;

    /**
     * TODO: javadoc
     */
    private Long amount;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}

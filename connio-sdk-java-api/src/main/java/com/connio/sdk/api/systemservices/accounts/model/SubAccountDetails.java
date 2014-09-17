package com.connio.sdk.api.systemservices.accounts.model;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class SubAccountDetails implements Serializable {

    /**
     * TODO: javadoc
     */
    private String ownerAccountSid;

    /**
     * TODO: javadoc
     */
    private String sid;

    /**
     * TODO: javadoc
     */
    private String displayName;

    /**
     * TODO: javadoc
     */
    private PlanType planType;

    /**
     * TODO: javadoc
     */
    private StatusType status;

    /**
     * TODO: javadoc
     */
    private Date dateCreated;

    /**
     * TODO: javadoc
     */
    private Date dateModified;

    /**
     * TODO: javadoc
     */
    private String authToken;

    /**
     * TODO: javadoc
     */
    private String uri;

    /**
     * TODO: javadoc
     */
    private String devicesUri;

    /**
     * TODO: javadoc
     */
    private String accountsUri;

    /**
     * TODO: javadoc
     */
    private String deviceProfilesUri;

    /**
     * TODO: javadoc
     */
    private String appsUri;

    /**
     * TODO: javadoc
     */
    private String billingInfoUri;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public void PlanType(PlanType planType) {
        this.planType = planType;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDevicesUri() {
        return devicesUri;
    }

    public void setDevicesUri(String devicesUri) {
        this.devicesUri = devicesUri;
    }

    public String getAccountsUri() {
        return accountsUri;
    }

    public void setAccountsUri(String accountsUri) {
        this.accountsUri = accountsUri;
    }

    public String getDeviceProfilesUri() {
        return deviceProfilesUri;
    }

    public void setDeviceProfilesUri(String deviceProfilesUri) {
        this.deviceProfilesUri = deviceProfilesUri;
    }

    public String getAppsUri() {
        return appsUri;
    }

    public void setAppsUri(String appsUri) {
        this.appsUri = appsUri;
    }

    public String getBillingInfoUri() {
        return billingInfoUri;
    }

    public void setBillingInfoUri(String billingInfoUri) {
        this.billingInfoUri = billingInfoUri;
    }

    public String getOwnerAccountSid() {
        return ownerAccountSid;
    }

    public void setOwnerAccountSid(String ownerAccountSid) {
        this.ownerAccountSid = ownerAccountSid;
    }
}

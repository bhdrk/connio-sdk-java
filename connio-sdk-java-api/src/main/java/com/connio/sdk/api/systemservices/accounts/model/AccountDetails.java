package com.connio.sdk.api.systemservices.accounts.model;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class AccountDetails implements Serializable {

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
    private String deviceprofilesUri;

    /**
     * TODO: javadoc
     */
    private String appsUri;

    /**
     * TODO: javadoc
     */
    private String usersUri;

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

    public void setPlanType(PlanType planType) {
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

    public String getDeviceprofilesUri() {
        return deviceprofilesUri;
    }

    public void setDeviceprofilesUri(String deviceprofilesUri) {
        this.deviceprofilesUri = deviceprofilesUri;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountDetails that = (AccountDetails) o;

        if (accountsUri != null ? !accountsUri.equals(that.accountsUri) : that.accountsUri != null) return false;
        if (appsUri != null ? !appsUri.equals(that.appsUri) : that.appsUri != null) return false;
        if (authToken != null ? !authToken.equals(that.authToken) : that.authToken != null) return false;
        if (billingInfoUri != null ? !billingInfoUri.equals(that.billingInfoUri) : that.billingInfoUri != null)
            return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (dateModified != null ? !dateModified.equals(that.dateModified) : that.dateModified != null) return false;
        if (deviceprofilesUri != null ? !deviceprofilesUri.equals(that.deviceprofilesUri) : that.deviceprofilesUri != null)
            return false;
        if (devicesUri != null ? !devicesUri.equals(that.devicesUri) : that.devicesUri != null) return false;
        if (displayName != null ? !displayName.equals(that.displayName) : that.displayName != null) return false;
        if (planType != that.planType) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (status != that.status) return false;
        if (uri != null ? !uri.equals(that.uri) : that.uri != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (planType != null ? planType.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        result = 31 * result + (authToken != null ? authToken.hashCode() : 0);
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        result = 31 * result + (devicesUri != null ? devicesUri.hashCode() : 0);
        result = 31 * result + (accountsUri != null ? accountsUri.hashCode() : 0);
        result = 31 * result + (deviceprofilesUri != null ? deviceprofilesUri.hashCode() : 0);
        result = 31 * result + (appsUri != null ? appsUri.hashCode() : 0);
        result = 31 * result + (billingInfoUri != null ? billingInfoUri.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "sid='" + sid + '\'' +
                ", displayName='" + displayName + '\'' +
                ", planType=" + planType +
                ", status=" + status +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", authToken='" + authToken + '\'' +
                ", uri='" + uri + '\'' +
                ", devicesUri='" + devicesUri + '\'' +
                ", accountsUri='" + accountsUri + '\'' +
                ", deviceprofilesUri='" + deviceprofilesUri + '\'' +
                ", appsUri='" + appsUri + '\'' +
                ", billingInfoUri='" + billingInfoUri + '\'' +
                '}';
    }

    public String getUsersUri() {
        return usersUri;
    }

    public void setUsersUri(String usersUri) {
        this.usersUri = usersUri;
    }
}

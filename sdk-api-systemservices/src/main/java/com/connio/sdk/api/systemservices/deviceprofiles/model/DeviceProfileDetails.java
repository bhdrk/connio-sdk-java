package com.connio.sdk.api.systemservices.deviceprofiles.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public class DeviceProfileDetails implements Serializable {

    /**
     * TODO: javadoc
     */
    private String name;

    /**
     * TODO: javadoc
     */
    private String description;

    /**
     * TODO: javadoc
     */
    private String sid;

    /**
     * TODO: javadoc
     */
    private String accountSid;

    /**
     * TODO: javadoc
     */
    private String clazz;

    /**
     * TODO: javadoc
     */
    private String subclass;

    /**
     * TODO: javadoc
     */
    private String vendor;

    /**
     * TODO: javadoc
     */
    private String product;

    /**
     * TODO: javadoc
     */
    private String uri;

    /**
     * TODO: javadoc
     */
    private String dateCreated;

    /**
     * TODO: javadoc
     */
    private String dateModified;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceProfileDetails that = (DeviceProfileDetails) o;

        if (accountSid != null ? !accountSid.equals(that.accountSid) : that.accountSid != null) return false;
        if (clazz != null ? !clazz.equals(that.clazz) : that.clazz != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (dateModified != null ? !dateModified.equals(that.dateModified) : that.dateModified != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (subclass != null ? !subclass.equals(that.subclass) : that.subclass != null) return false;
        if (uri != null ? !uri.equals(that.uri) : that.uri != null) return false;
        if (vendor != null ? !vendor.equals(that.vendor) : that.vendor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (accountSid != null ? accountSid.hashCode() : 0);
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        result = 31 * result + (subclass != null ? subclass.hashCode() : 0);
        result = 31 * result + (vendor != null ? vendor.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceProfileDetails{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sid='" + sid + '\'' +
                ", accountSid='" + accountSid + '\'' +
                ", clazz='" + clazz + '\'' +
                ", subclass='" + subclass + '\'' +
                ", vendor='" + vendor + '\'' +
                ", product='" + product + '\'' +
                ", uri='" + uri + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", dateModified='" + dateModified + '\'' +
                '}';
    }
}

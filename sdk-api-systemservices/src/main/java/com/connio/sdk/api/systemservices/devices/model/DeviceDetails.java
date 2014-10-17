package com.connio.sdk.api.systemservices.devices.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class DeviceDetails implements Serializable {

    private String sid;

    private String accountSid;

    private String subaccountSid;

    private Map<CidType, String> cidMap;

    private Date dateCreated;

    private Date dateModified;

    private String notes;

    private String profileName;

    private DeviceStatusType status;

    private String uri;

    private String accessKeyUri;

    private Location loc;

    private List<String> tags;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getSubaccountSid() {
        return subaccountSid;
    }

    public void setSubaccountSid(String subaccountSid) {
        this.subaccountSid = subaccountSid;
    }

    public Map<CidType, String> getCidMap() {
        return cidMap;
    }

    public void setCidMap(Map<CidType, String> cidMap) {
        this.cidMap = cidMap;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public DeviceStatusType getStatus() {
        return status;
    }

    public void setStatus(DeviceStatusType status) {
        this.status = status;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getAccessKeyUri() {
        return accessKeyUri;
    }

    public void setAccessKeyUri(String accessKeyUri) {
        this.accessKeyUri = accessKeyUri;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceDetails that = (DeviceDetails) o;

        if (accessKeyUri != null ? !accessKeyUri.equals(that.accessKeyUri) : that.accessKeyUri != null) return false;
        if (accountSid != null ? !accountSid.equals(that.accountSid) : that.accountSid != null) return false;
        if (cidMap != null ? !cidMap.equals(that.cidMap) : that.cidMap != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (dateModified != null ? !dateModified.equals(that.dateModified) : that.dateModified != null) return false;
        if (loc != null ? !loc.equals(that.loc) : that.loc != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (profileName != null ? !profileName.equals(that.profileName) : that.profileName != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (status != that.status) return false;
        if (subaccountSid != null ? !subaccountSid.equals(that.subaccountSid) : that.subaccountSid != null)
            return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
        if (uri != null ? !uri.equals(that.uri) : that.uri != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (accountSid != null ? accountSid.hashCode() : 0);
        result = 31 * result + (subaccountSid != null ? subaccountSid.hashCode() : 0);
        result = 31 * result + (cidMap != null ? cidMap.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (profileName != null ? profileName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        result = 31 * result + (accessKeyUri != null ? accessKeyUri.hashCode() : 0);
        result = 31 * result + (loc != null ? loc.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceDetails{" +
                "sid='" + sid + '\'' +
                ", accountSid='" + accountSid + '\'' +
                ", subaccountSid='" + subaccountSid + '\'' +
                ", cidMap=" + cidMap +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", notes='" + notes + '\'' +
                ", profileName='" + profileName + '\'' +
                ", status=" + status +
                ", uri='" + uri + '\'' +
                ", accessKeyUri='" + accessKeyUri + '\'' +
                ", loc=" + loc +
                ", tags=" + tags +
                '}';
    }
}

package com.connio.sdk.api.systemservices.apps.model;

import com.connio.sdk.api.systemservices.datachannels.model.DataChannelDetails;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class AppDetails implements Serializable {

    /**
     * TODO: javadoc
     */
    private String name;

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
    private String description;

    /**
     * TODO: javadoc
     */
    private String dateCreated;

    /**
     * TODO: javadoc
     */
    private String dateModified;

    /**
     * TODO: javadoc
     */
    private String version;

    /**
     * TODO: javadoc
     */
    private AppStateType state;

    /**
     * TODO: javadoc
     */
    private String accountSid;

    /**
     * TODO: javadoc
     */
    private Long appStorageCapacity;

    /**
     * TODO: javadoc
     */
    private Long accAvailableStorage;

    /**
     * TODO: javadoc
     */
    private String triggersUri;

    /**
     * TODO: javadoc
     */
    private String logicUri;

    /**
     * TODO: javadoc
     */
    private String usageUri;

    /**
     * TODO: javadoc
     */
    private String logsUri;

    /**
     * TODO: javadoc
     */
    private String datafeedUri;

    /**
     * TODO: javadoc
     */
    private String uri;

    /**
     * TODO: javadoc
     */
    private String iconUrl;

    /**
     * TODO: javadoc
     */
    private List<DataChannelDetails> datachannels;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public AppStateType getState() {
        return state;
    }

    public void setState(AppStateType state) {
        this.state = state;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public Long getAppStorageCapacity() {
        return appStorageCapacity;
    }

    public void setAppStorageCapacity(Long appStorageCapacity) {
        this.appStorageCapacity = appStorageCapacity;
    }

    public Long getAccAvailableStorage() {
        return accAvailableStorage;
    }

    public void setAccAvailableStorage(Long accAvailableStorage) {
        this.accAvailableStorage = accAvailableStorage;
    }

    public String getTriggersUri() {
        return triggersUri;
    }

    public void setTriggersUri(String triggersUri) {
        this.triggersUri = triggersUri;
    }

    public String getLogicUri() {
        return logicUri;
    }

    public void setLogicUri(String logicUri) {
        this.logicUri = logicUri;
    }

    public String getUsageUri() {
        return usageUri;
    }

    public void setUsageUri(String usageUri) {
        this.usageUri = usageUri;
    }

    public String getLogsUri() {
        return logsUri;
    }

    public void setLogsUri(String logsUri) {
        this.logsUri = logsUri;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public List<DataChannelDetails> getDatachannels() {
        return datachannels;
    }

    public void setDatachannels(List<DataChannelDetails> datachannels) {
        this.datachannels = datachannels;
    }

    public String getDatafeedUri() {
        return datafeedUri;
    }

    public void setDatafeedUri(String datafeedUri) {
        this.datafeedUri = datafeedUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppDetails that = (AppDetails) o;

        if (accAvailableStorage != null ? !accAvailableStorage.equals(that.accAvailableStorage) : that.accAvailableStorage != null)
            return false;
        if (accountSid != null ? !accountSid.equals(that.accountSid) : that.accountSid != null) return false;
        if (appStorageCapacity != null ? !appStorageCapacity.equals(that.appStorageCapacity) : that.appStorageCapacity != null)
            return false;
        if (datachannels != null ? !datachannels.equals(that.datachannels) : that.datachannels != null) return false;
        if (datafeedUri != null ? !datafeedUri.equals(that.datafeedUri) : that.datafeedUri != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (dateModified != null ? !dateModified.equals(that.dateModified) : that.dateModified != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (displayName != null ? !displayName.equals(that.displayName) : that.displayName != null) return false;
        if (iconUrl != null ? !iconUrl.equals(that.iconUrl) : that.iconUrl != null) return false;
        if (logicUri != null ? !logicUri.equals(that.logicUri) : that.logicUri != null) return false;
        if (logsUri != null ? !logsUri.equals(that.logsUri) : that.logsUri != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (state != that.state) return false;
        if (triggersUri != null ? !triggersUri.equals(that.triggersUri) : that.triggersUri != null) return false;
        if (uri != null ? !uri.equals(that.uri) : that.uri != null) return false;
        if (usageUri != null ? !usageUri.equals(that.usageUri) : that.usageUri != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (accountSid != null ? accountSid.hashCode() : 0);
        result = 31 * result + (appStorageCapacity != null ? appStorageCapacity.hashCode() : 0);
        result = 31 * result + (accAvailableStorage != null ? accAvailableStorage.hashCode() : 0);
        result = 31 * result + (triggersUri != null ? triggersUri.hashCode() : 0);
        result = 31 * result + (logicUri != null ? logicUri.hashCode() : 0);
        result = 31 * result + (usageUri != null ? usageUri.hashCode() : 0);
        result = 31 * result + (logsUri != null ? logsUri.hashCode() : 0);
        result = 31 * result + (datafeedUri != null ? datafeedUri.hashCode() : 0);
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        result = 31 * result + (iconUrl != null ? iconUrl.hashCode() : 0);
        result = 31 * result + (datachannels != null ? datachannels.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AppDetails{" +
                "name='" + name + '\'' +
                ", sid='" + sid + '\'' +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", dateModified='" + dateModified + '\'' +
                ", version='" + version + '\'' +
                ", state=" + state +
                ", accountSid='" + accountSid + '\'' +
                ", appStorageCapacity=" + appStorageCapacity +
                ", accAvailableStorage=" + accAvailableStorage +
                ", triggersUri='" + triggersUri + '\'' +
                ", logicUri='" + logicUri + '\'' +
                ", usageUri='" + usageUri + '\'' +
                ", logsUri='" + logsUri + '\'' +
                ", datafeedUri='" + datafeedUri + '\'' +
                ", uri='" + uri + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", datachannels=" + datachannels +
                '}';
    }
}

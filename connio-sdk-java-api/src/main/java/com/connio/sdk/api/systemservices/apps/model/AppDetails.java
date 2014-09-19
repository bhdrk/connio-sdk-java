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
    private StatusType status;

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
    private String uri;

    /**
     * TODO: javadoc
     */
    private String iconUrl;

    /**
     * TODO: javadoc
     */
    private List<DataChannelDetails> dataChannels;

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

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
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

    public List<DataChannelDetails> getDataChannels() {
        return dataChannels;
    }

    public void setDataChannels(List<DataChannelDetails> dataChannels) {
        this.dataChannels = dataChannels;
    }
}

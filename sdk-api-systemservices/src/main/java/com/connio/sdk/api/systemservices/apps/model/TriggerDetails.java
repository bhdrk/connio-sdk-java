package com.connio.sdk.api.systemservices.apps.model;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 14.11.2014.
 */
public class TriggerDetails implements Serializable {

    private String sid;

    private String appSid;

    private String channelSid;

    private String displayName;

    private Condition condition;

    private Frequency freq;

    private Date lastFired;

    private Date dateModified;

    private Date dateCreated;

    private TriggerAction action;

    private String baseType;

    private String uri;

    public TriggerDetails() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getAppSid() {
        return appSid;
    }

    public void setAppSid(String appSid) {
        this.appSid = appSid;
    }

    public String getChannelSid() {
        return channelSid;
    }

    public void setChannelSid(String channelSid) {
        this.channelSid = channelSid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Frequency getFreq() {
        return freq;
    }

    public void setFreq(Frequency freq) {
        this.freq = freq;
    }

    public Date getLastFired() {
        return lastFired;
    }

    public void setLastFired(Date lastFired) {
        this.lastFired = lastFired;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public TriggerAction getAction() {
        return action;
    }

    public void setAction(TriggerAction action) {
        this.action = action;
    }


    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TriggerDetails that = (TriggerDetails) o;

        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (appSid != null ? !appSid.equals(that.appSid) : that.appSid != null) return false;
        if (baseType != null ? !baseType.equals(that.baseType) : that.baseType != null) return false;
        if (channelSid != null ? !channelSid.equals(that.channelSid) : that.channelSid != null) return false;
        if (condition != null ? !condition.equals(that.condition) : that.condition != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (dateModified != null ? !dateModified.equals(that.dateModified) : that.dateModified != null) return false;
        if (displayName != null ? !displayName.equals(that.displayName) : that.displayName != null) return false;
        if (freq != null ? !freq.equals(that.freq) : that.freq != null) return false;
        if (lastFired != null ? !lastFired.equals(that.lastFired) : that.lastFired != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (uri != null ? !uri.equals(that.uri) : that.uri != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (appSid != null ? appSid.hashCode() : 0);
        result = 31 * result + (channelSid != null ? channelSid.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        result = 31 * result + (freq != null ? freq.hashCode() : 0);
        result = 31 * result + (lastFired != null ? lastFired.hashCode() : 0);
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (baseType != null ? baseType.hashCode() : 0);
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TriggerDetails{" +
                "sid='" + sid + '\'' +
                ", appSid='" + appSid + '\'' +
                ", channelSid='" + channelSid + '\'' +
                ", displayName='" + displayName + '\'' +
                ", condition=" + condition +
                ", freq=" + freq +
                ", lastFired=" + lastFired +
                ", dateModified=" + dateModified +
                ", dateCreated=" + dateCreated +
                ", action=" + action +
                ", baseType='" + baseType + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}

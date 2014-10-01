package com.connio.sdk.api.systemservices.datachannels.model;

import com.connio.sdk.api.systemservices.datachannels.model.measurement.MeasurementType;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class DataChannelDetails implements Serializable {

    /**
     * TODO: javadoc
     */
    private String sid;

    /**
     * TODO: javadoc
     */
    private String name;

    /**
     * TODO: javadoc
     */
    private Alarm alarm;

    /**
     * TODO: javadoc
     */
    private String uri;

    /**
     * TODO: javadoc
     */
    private String ownerAppUri;

    /**
     * TODO: javadoc
     */
    private String datafeedUri;

    /**
     * TODO: javadoc
     */
    private String accountSid;

    /**
     * TODO: javadoc
     */
    private String appSid;

    /**
     * TODO: javadoc
     */
    private ChannelType channelType;

    /**
     * TODO: javadoc
     */
    private MeasurementType measurementType;

    /**
     * TODO: javadoc
     */
    private String measurementUnit;

    /**
     * TODO: javadoc
     */
    private Integer retentionPeriod;

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
    private BaseType baseType;

    /**
     * TODO: javadoc
     */
    private Bounds bounds;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getOwnerAppUri() {
        return ownerAppUri;
    }

    public void setOwnerAppUri(String ownerAppUri) {
        this.ownerAppUri = ownerAppUri;
    }

    public String getDatafeedUri() {
        return datafeedUri;
    }

    public void setDatafeedUri(String datafeedUri) {
        this.datafeedUri = datafeedUri;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAppSid() {
        return appSid;
    }

    public void setAppSid(String appSid) {
        this.appSid = appSid;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }

    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public Integer getRetentionPeriod() {
        return retentionPeriod;
    }

    public void setRetentionPeriod(Integer retentionPeriod) {
        this.retentionPeriod = retentionPeriod;
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

    public BaseType getBaseType() {
        return baseType;
    }

    public void setBaseType(BaseType baseType) {
        this.baseType = baseType;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataChannelDetails that = (DataChannelDetails) o;

        if (accountSid != null ? !accountSid.equals(that.accountSid) : that.accountSid != null) return false;
        if (alarm != null ? !alarm.equals(that.alarm) : that.alarm != null) return false;
        if (appSid != null ? !appSid.equals(that.appSid) : that.appSid != null) return false;
        if (baseType != that.baseType) return false;
        if (bounds != null ? !bounds.equals(that.bounds) : that.bounds != null) return false;
        if (channelType != that.channelType) return false;
        if (datafeedUri != null ? !datafeedUri.equals(that.datafeedUri) : that.datafeedUri != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (dateModified != null ? !dateModified.equals(that.dateModified) : that.dateModified != null) return false;
        if (measurementType != that.measurementType) return false;
        if (measurementUnit != null ? !measurementUnit.equals(that.measurementUnit) : that.measurementUnit != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (ownerAppUri != null ? !ownerAppUri.equals(that.ownerAppUri) : that.ownerAppUri != null) return false;
        if (retentionPeriod != null ? !retentionPeriod.equals(that.retentionPeriod) : that.retentionPeriod != null)
            return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (uri != null ? !uri.equals(that.uri) : that.uri != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (alarm != null ? alarm.hashCode() : 0);
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        result = 31 * result + (ownerAppUri != null ? ownerAppUri.hashCode() : 0);
        result = 31 * result + (datafeedUri != null ? datafeedUri.hashCode() : 0);
        result = 31 * result + (accountSid != null ? accountSid.hashCode() : 0);
        result = 31 * result + (appSid != null ? appSid.hashCode() : 0);
        result = 31 * result + (channelType != null ? channelType.hashCode() : 0);
        result = 31 * result + (measurementType != null ? measurementType.hashCode() : 0);
        result = 31 * result + (measurementUnit != null ? measurementUnit.hashCode() : 0);
        result = 31 * result + (retentionPeriod != null ? retentionPeriod.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        result = 31 * result + (baseType != null ? baseType.hashCode() : 0);
        result = 31 * result + (bounds != null ? bounds.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataChannelDetails{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", alarm=" + alarm +
                ", uri='" + uri + '\'' +
                ", ownerAppUri='" + ownerAppUri + '\'' +
                ", datafeedUri='" + datafeedUri + '\'' +
                ", accountSid='" + accountSid + '\'' +
                ", appSid='" + appSid + '\'' +
                ", channelType=" + channelType +
                ", measurementType=" + measurementType +
                ", measurementUnit='" + measurementUnit + '\'' +
                ", retentionPeriod=" + retentionPeriod +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", baseType=" + baseType +
                ", bounds=" + bounds +
                '}';
    }
}

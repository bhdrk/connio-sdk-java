package com.connio.sdk.api.systemservices.datachannels.model;

import com.connio.sdk.api.systemservices.datachannels.model.measurement.MeasurementType;
import com.connio.sdk.api.systemservices.datachannels.model.measurement.MeasurementUnit;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    private List<Alarm> alarm;

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
    private MeasurementUnit measurementUnit;

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
    private List<Bound> bounds;

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

    public List<Alarm> getAlarm() {
        return alarm;
    }

    public void setAlarm(List<Alarm> alarm) {
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

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
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

    public List<Bound> getBounds() {
        return bounds;
    }

    public void setBounds(List<Bound> bounds) {
        this.bounds = bounds;
    }
}

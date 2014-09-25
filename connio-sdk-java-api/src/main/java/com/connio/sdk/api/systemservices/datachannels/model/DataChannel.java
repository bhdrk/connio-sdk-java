package com.connio.sdk.api.systemservices.datachannels.model;

import com.connio.sdk.api.systemservices.datachannels.model.measurement.MeasurementType;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 24.09.2014
 */
public class DataChannel implements Serializable {

    /**
     * TODO: javadoc
     */
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

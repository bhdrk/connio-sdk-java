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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataChannel that = (DataChannel) o;

        if (channelType != that.channelType) return false;
        if (measurementType != that.measurementType) return false;
        if (measurementUnit != null ? !measurementUnit.equals(that.measurementUnit) : that.measurementUnit != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (channelType != null ? channelType.hashCode() : 0);
        result = 31 * result + (measurementType != null ? measurementType.hashCode() : 0);
        result = 31 * result + (measurementUnit != null ? measurementUnit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataChannel{" +
                "name='" + name + '\'' +
                ", channelType=" + channelType +
                ", measurementType=" + measurementType +
                ", measurementUnit='" + measurementUnit + '\'' +
                '}';
    }
}

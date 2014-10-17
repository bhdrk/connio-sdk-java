package com.connio.sdk.api.systemservices.datachannels.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 24.09.2014
 */
public class DataChannelUpdate implements Serializable {

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
    private Bounds bounds;

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

    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
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

        DataChannelUpdate that = (DataChannelUpdate) o;

        if (alarm != null ? !alarm.equals(that.alarm) : that.alarm != null) return false;
        if (bounds != null ? !bounds.equals(that.bounds) : that.bounds != null) return false;
        if (measurementUnit != null ? !measurementUnit.equals(that.measurementUnit) : that.measurementUnit != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (alarm != null ? alarm.hashCode() : 0);
        result = 31 * result + (bounds != null ? bounds.hashCode() : 0);
        result = 31 * result + (measurementUnit != null ? measurementUnit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataChannelUpdate{" +
                "name='" + name + '\'' +
                ", alarm=" + alarm +
                ", bounds=" + bounds +
                ", measurementUnit='" + measurementUnit + '\'' +
                '}';
    }
}

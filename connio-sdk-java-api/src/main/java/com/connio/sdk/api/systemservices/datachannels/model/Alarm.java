package com.connio.sdk.api.systemservices.datachannels.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class Alarm implements Serializable {

    /**
     * TODO: javadoc
     */
    private AlarmType type;

    /**
     * TODO: javadoc
     */
    private Long value;

    /**
     * TODO: javadoc
     */
    private Duration duration;

    /**
     * TODO: javadoc
     */
    private AlarmAction action;

    public AlarmType getType() {
        return type;
    }

    public void setType(AlarmType type) {
        this.type = type;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public AlarmAction getAction() {
        return action;
    }

    public void setAction(AlarmAction action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alarm alarm = (Alarm) o;

        if (action != null ? !action.equals(alarm.action) : alarm.action != null) return false;
        if (duration != alarm.duration) return false;
        if (type != alarm.type) return false;
        if (value != null ? !value.equals(alarm.value) : alarm.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "type=" + type +
                ", value=" + value +
                ", duration=" + duration +
                ", action=" + action +
                '}';
    }
}

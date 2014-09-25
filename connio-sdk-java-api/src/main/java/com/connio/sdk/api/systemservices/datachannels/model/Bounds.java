package com.connio.sdk.api.systemservices.datachannels.model;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 12.09.2014
 */
public class Bounds implements Serializable {

    /**
     * TODO: javadoc
     */
    private List<EventKeyValue> events;

    /**
     * TODO: javadoc
     */
    private BoundsAction action;

    /**
     * TODO: javadoc
     */
    private Long min;

    /**
     * TODO: javadoc
     */
    private Long max;

    /**
     * TODO: javadoc
     */
    private List<String> predefs;

    public List<EventKeyValue> getEvents() {
        return events;
    }

    public void setEvents(List<EventKeyValue> events) {
        this.events = events;
    }

    public BoundsAction getAction() {
        return action;
    }

    public void setAction(BoundsAction action) {
        this.action = action;
    }

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public List<String> getPredefs() {
        return predefs;
    }

    public void setPredefs(List<String> predefs) {
        this.predefs = predefs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bounds bounds = (Bounds) o;

        if (action != null ? !action.equals(bounds.action) : bounds.action != null) return false;
        if (events != null ? !events.equals(bounds.events) : bounds.events != null) return false;
        if (max != null ? !max.equals(bounds.max) : bounds.max != null) return false;
        if (min != null ? !min.equals(bounds.min) : bounds.min != null) return false;
        if (predefs != null ? !predefs.equals(bounds.predefs) : bounds.predefs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = events != null ? events.hashCode() : 0;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (min != null ? min.hashCode() : 0);
        result = 31 * result + (max != null ? max.hashCode() : 0);
        result = 31 * result + (predefs != null ? predefs.hashCode() : 0);
        return result;
    }
}

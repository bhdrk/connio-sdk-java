package com.connio.sdk.api.systemservices.datachannels.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
    private List<Map<String, String>> events;

    /**
     * TODO: javadoc
     */
    private Action action;

    /**
     * TODO: javadoc
     */
    private Long min;

    /**
     * TODO: javadoc
     */
    private Long max;

    public List<Map<String, String>> getEvents() {
        return events;
    }

    public void setEvents(List<Map<String, String>> events) {
        this.events = events;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
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
}

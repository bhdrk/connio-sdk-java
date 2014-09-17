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
    private String type;

    /**
     * TODO: javadoc
     */
    private Long value;

    /**
     * TODO: javadoc
     */
    private String duration;

    /**
     * TODO: javadoc
     */
    private Action action;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}

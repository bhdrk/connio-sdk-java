package com.connio.sdk.api.systemservices.apps.model;

import java.io.Serializable;

/**
 * TODO:javadoc
 * <p/>
 * Created by bdirik on 13.11.2014.
 */
public class Trigger implements Serializable {

    private String displayName;

    private Condition condition;

    private TriggerAction action;

    private Frequency freq;

    private String channelSid;

    public Trigger() {
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

    public TriggerAction getAction() {
        return action;
    }

    public void setAction(TriggerAction action) {
        this.action = action;
    }

    public Frequency getFreq() {
        return freq;
    }

    public void setFreq(Frequency freq) {
        this.freq = freq;
    }

    public String getChannelSid() {
        return channelSid;
    }

    public void setChannelSid(String channelSid) {
        this.channelSid = channelSid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trigger trigger = (Trigger) o;

        if (action != null ? !action.equals(trigger.action) : trigger.action != null) return false;
        if (channelSid != null ? !channelSid.equals(trigger.channelSid) : trigger.channelSid != null) return false;
        if (condition != null ? !condition.equals(trigger.condition) : trigger.condition != null) return false;
        if (displayName != null ? !displayName.equals(trigger.displayName) : trigger.displayName != null) return false;
        if (freq != null ? !freq.equals(trigger.freq) : trigger.freq != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = displayName != null ? displayName.hashCode() : 0;
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (freq != null ? freq.hashCode() : 0);
        result = 31 * result + (channelSid != null ? channelSid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Trigger{" +
                "displayName='" + displayName + '\'' +
                ", condition=" + condition +
                ", action=" + action +
                ", freq=" + freq +
                ", channelSid='" + channelSid + '\'' +
                '}';
    }
}

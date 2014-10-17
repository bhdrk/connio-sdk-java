package com.connio.sdk.api.dataservices.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bdirik on 16.10.2014.
 */
public class DataPoint implements Serializable {

    private Long time;
    private String value;

    private String _feedId;
    private Location _loc;
    private String _srcUri;
    private List<String> _tags;
    private String _chan;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFeedId() {
        return _feedId;
    }

    public void setFeedId(String feedId) {
        this._feedId = feedId;
    }

    public Location getLoc() {
        return _loc;
    }

    public void setLoc(Location loc) {
        this._loc = loc;
    }

    public String getSrcUri() {
        return _srcUri;
    }

    public void setSrcUri(String srcUri) {
        this._srcUri = srcUri;
    }

    public List<String> getTags() {
        return _tags;
    }

    public void setTags(List<String> tags) {
        this._tags = tags;
    }

    public String getChan() {
        return _chan;
    }

    public void setChan(String chan) {
        this._chan = chan;
    }
}

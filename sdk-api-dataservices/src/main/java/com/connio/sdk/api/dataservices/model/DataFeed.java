package com.connio.sdk.api.dataservices.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bdirik on 16.10.2014.
 */
public class DataFeed implements Serializable {

    private String _id;
    private String _srcUri;
    private String _chan;
    private Location _loc;
    private List<String> _tags;

    private List<DataPoint> datapoints;

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getSrcUri() {
        return _srcUri;
    }

    public void setSrcUri(String srcUri) {
        this._srcUri = srcUri;
    }

    public String getChan() {
        return _chan;
    }

    public void setChan(String chan) {
        this._chan = chan;
    }

    public Location getLoc() {
        return _loc;
    }

    public void setLoc(Location loc) {
        this._loc = loc;
    }

    public List<String> getTags() {
        return _tags;
    }

    public void setTags(List<String> tags) {
        this._tags = tags;
    }

    public List<DataPoint> getDatapoints() {
        return datapoints;
    }

    public void setDatapoints(List<DataPoint> datapoints) {
        this.datapoints = datapoints;
    }
}

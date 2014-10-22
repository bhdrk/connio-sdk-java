package com.connio.sdk.api.dataservices.model;

import com.connio.sdk.api.model.Location;
import com.connio.sdk.api.utils.Asserts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 16.10.2014.
 */
public class DataFeed implements Serializable {

    private List<DataPoint> datapoints = new ArrayList<DataPoint>();

    private String _id;
    private String _srcUri;
    private String _chan;
    private Location _loc;
    private List<String> _tags;

    public DataFeed() {
    }

    public DataFeed(List<DataPoint> datapoints) {
        this.datapoints = datapoints;
    }

    public DataFeed(DataPoint... datapoints) {
        Asserts.notEmpty(datapoints, "DataPoints");

        for (DataPoint datapoint : datapoints) {
            addDataPoint(datapoint);
        }
    }

    public void addDataPoint(DataPoint dataPoint) {
        Asserts.notNull(dataPoint.getValue(), "Value");
        Asserts.notNull(dataPoint.getTime(), "Time");

        datapoints.add(dataPoint);
    }

    public List<DataPoint> getDatapoints() {
        return datapoints;
    }

    public void setDatapoints(List<DataPoint> datapoints) {
        this.datapoints = datapoints;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_srcUri() {
        return _srcUri;
    }

    public void set_srcUri(String _srcUri) {
        this._srcUri = _srcUri;
    }

    public String get_chan() {
        return _chan;
    }

    public void set_chan(String _chan) {
        this._chan = _chan;
    }

    public Location get_loc() {
        return _loc;
    }

    public void set_loc(Location _loc) {
        this._loc = _loc;
    }

    public List<String> get_tags() {
        return _tags;
    }

    public void set_tags(List<String> _tags) {
        this._tags = _tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataFeed dataFeed = (DataFeed) o;

        if (_chan != null ? !_chan.equals(dataFeed._chan) : dataFeed._chan != null) return false;
        if (_id != null ? !_id.equals(dataFeed._id) : dataFeed._id != null) return false;
        if (_loc != null ? !_loc.equals(dataFeed._loc) : dataFeed._loc != null) return false;
        if (_srcUri != null ? !_srcUri.equals(dataFeed._srcUri) : dataFeed._srcUri != null) return false;
        if (_tags != null ? !_tags.equals(dataFeed._tags) : dataFeed._tags != null) return false;
        if (datapoints != null ? !datapoints.equals(dataFeed.datapoints) : dataFeed.datapoints != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = datapoints != null ? datapoints.hashCode() : 0;
        result = 31 * result + (_id != null ? _id.hashCode() : 0);
        result = 31 * result + (_srcUri != null ? _srcUri.hashCode() : 0);
        result = 31 * result + (_chan != null ? _chan.hashCode() : 0);
        result = 31 * result + (_loc != null ? _loc.hashCode() : 0);
        result = 31 * result + (_tags != null ? _tags.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataFeed{" +
                "datapoints=" + datapoints +
                ", _id='" + _id + '\'' +
                ", _srcUri='" + _srcUri + '\'' +
                ", _chan='" + _chan + '\'' +
                ", _loc=" + _loc +
                ", _tags=" + _tags +
                '}';
    }
}

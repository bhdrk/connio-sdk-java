package com.connio.sdk.api.dataservices.model;

import com.connio.sdk.api.model.Location;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: javadoc
 *
 * Created by bdirik on 16.10.2014.
 */
public class DataPoint implements Serializable {

    private Long time;
    private Object value;

    private String _feedId;
    private Location _loc;
    private String _srcUri;
    private List<String> _tags;
    private String _chan;

    public DataPoint() {
    }

    public DataPoint(Long time, Object value) {
        this.time = time;
        this.value = value;
    }

    public DataPoint(Long time, Object value, String _chan) {
        this.time = time;
        this.value = value;
        this._chan = _chan;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String get_feedId() {
        return _feedId;
    }

    public void set_feedId(String _feedId) {
        this._feedId = _feedId;
    }

    public Location get_loc() {
        return _loc;
    }

    public void set_loc(Location _loc) {
        this._loc = _loc;
    }

    public String get_srcUri() {
        return _srcUri;
    }

    public void set_srcUri(String _srcUri) {
        this._srcUri = _srcUri;
    }

    public List<String> get_tags() {
        return _tags;
    }

    public void set_tags(List<String> _tags) {
        this._tags = _tags;
    }

    public String get_chan() {
        return _chan;
    }

    public void set_chan(String _chan) {
        this._chan = _chan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataPoint dataPoint = (DataPoint) o;

        if (_chan != null ? !_chan.equals(dataPoint._chan) : dataPoint._chan != null) return false;
        if (_feedId != null ? !_feedId.equals(dataPoint._feedId) : dataPoint._feedId != null) return false;
        if (_loc != null ? !_loc.equals(dataPoint._loc) : dataPoint._loc != null) return false;
        if (_srcUri != null ? !_srcUri.equals(dataPoint._srcUri) : dataPoint._srcUri != null) return false;
        if (_tags != null ? !_tags.equals(dataPoint._tags) : dataPoint._tags != null) return false;
        if (time != null ? !time.equals(dataPoint.time) : dataPoint.time != null) return false;
        if (value != null ? !value.equals(dataPoint.value) : dataPoint.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (_feedId != null ? _feedId.hashCode() : 0);
        result = 31 * result + (_loc != null ? _loc.hashCode() : 0);
        result = 31 * result + (_srcUri != null ? _srcUri.hashCode() : 0);
        result = 31 * result + (_tags != null ? _tags.hashCode() : 0);
        result = 31 * result + (_chan != null ? _chan.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataPoint{" +
                "time=" + time +
                ", value='" + value + '\'' +
                ", _feedId='" + _feedId + '\'' +
                ", _loc=" + _loc +
                ", _srcUri='" + _srcUri + '\'' +
                ", _tags=" + _tags +
                ", _chan='" + _chan + '\'' +
                '}';
    }
}

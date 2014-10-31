package com.connio.sdk.api.dataservices.model;

import com.connio.sdk.api.model.Location;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by bdirik on 20.10.2014.
 */
public class DataPointDetails implements Serializable {

    private Long time;
    private Object value;

    private String _feedId;
    private Location _loc;
    private String _srcUri;
    private List<String> _tags;
    private String _chan;
    private String _remIp;
    private Date _srvTime;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
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

    public String get_remIp() {
        return _remIp;
    }

    public void set_remIp(String _remIp) {
        this._remIp = _remIp;
    }

    public Date get_srvTime() {
        return _srvTime;
    }

    public void set_srvTime(Date _srvTime) {
        this._srvTime = _srvTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataPointDetails that = (DataPointDetails) o;

        if (_chan != null ? !_chan.equals(that._chan) : that._chan != null) return false;
        if (_feedId != null ? !_feedId.equals(that._feedId) : that._feedId != null) return false;
        if (_loc != null ? !_loc.equals(that._loc) : that._loc != null) return false;
        if (_remIp != null ? !_remIp.equals(that._remIp) : that._remIp != null) return false;
        if (_srcUri != null ? !_srcUri.equals(that._srcUri) : that._srcUri != null) return false;
        if (_srvTime != null ? !_srvTime.equals(that._srvTime) : that._srvTime != null) return false;
        if (_tags != null ? !_tags.equals(that._tags) : that._tags != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

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
        result = 31 * result + (_remIp != null ? _remIp.hashCode() : 0);
        result = 31 * result + (_srvTime != null ? _srvTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataPointDetails{" +
                "time=" + time +
                ", value='" + value + '\'' +
                ", _feedId='" + _feedId + '\'' +
                ", _loc=" + _loc +
                ", _srcUri='" + _srcUri + '\'' +
                ", _tags=" + _tags +
                ", _chan='" + _chan + '\'' +
                ", _remIp='" + _remIp + '\'' +
                ", _srvTime=" + _srvTime +
                '}';
    }
}

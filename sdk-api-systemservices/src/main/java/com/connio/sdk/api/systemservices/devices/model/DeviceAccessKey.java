package com.connio.sdk.api.systemservices.devices.model;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class DeviceAccessKey implements Serializable {

    private String authToken;

    private String sid;

    private String uri;

    private List<DevicePermission> perms;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<DevicePermission> getPerms() {
        return perms;
    }

    public void setPerms(List<DevicePermission> perms) {
        this.perms = perms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceAccessKey that = (DeviceAccessKey) o;

        if (authToken != null ? !authToken.equals(that.authToken) : that.authToken != null) return false;
        if (perms != null ? !perms.equals(that.perms) : that.perms != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (uri != null ? !uri.equals(that.uri) : that.uri != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authToken != null ? authToken.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        result = 31 * result + (perms != null ? perms.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceAccessKey{" +
                "authToken='" + authToken + '\'' +
                ", sid='" + sid + '\'' +
                ", uri='" + uri + '\'' +
                ", perms=" + perms +
                '}';
    }
}

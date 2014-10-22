package com.connio.sdk.api.systemservices.devices.model;

import com.connio.sdk.api.model.Location;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class Device implements Serializable {

    private String profileName;

    private Map<CidType, String> cidMap;

    private DeviceStatusType status;

    private Location loc;

    private String assignTo;

    private String notes;

    private List<String> tags;

    public void addCid(CidType cidType, String cid) {
        if (cidMap == null) {
            cidMap = new HashMap<CidType, String>();
        }
        cidMap.put(cidType, cid);
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Map<CidType, String> getCidMap() {
        return cidMap;
    }

    public void setCidMap(Map<CidType, String> cidMap) {
        this.cidMap = cidMap;
    }

    public DeviceStatusType getStatus() {
        return status;
    }

    public void setStatus(DeviceStatusType status) {
        this.status = status;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (assignTo != null ? !assignTo.equals(device.assignTo) : device.assignTo != null) return false;
        if (cidMap != null ? !cidMap.equals(device.cidMap) : device.cidMap != null) return false;
        if (loc != null ? !loc.equals(device.loc) : device.loc != null) return false;
        if (notes != null ? !notes.equals(device.notes) : device.notes != null) return false;
        if (profileName != null ? !profileName.equals(device.profileName) : device.profileName != null) return false;
        if (status != device.status) return false;
        if (tags != null ? !tags.equals(device.tags) : device.tags != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = profileName != null ? profileName.hashCode() : 0;
        result = 31 * result + (cidMap != null ? cidMap.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (loc != null ? loc.hashCode() : 0);
        result = 31 * result + (assignTo != null ? assignTo.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Device{" +
                "profileName='" + profileName + '\'' +
                ", cidMap=" + cidMap +
                ", status=" + status +
                ", loc=" + loc +
                ", assignTo='" + assignTo + '\'' +
                ", notes='" + notes + '\'' +
                ", tags=" + tags +
                '}';
    }
}

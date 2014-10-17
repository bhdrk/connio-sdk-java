package com.connio.sdk.api.systemservices.devices.model;

import java.io.Serializable;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class Cid implements Serializable {

    private String profileName;

    private CidType cidType;

    private String cid;

    public Cid(String profileName, CidType cidType, String cid) {
        this.profileName = profileName;
        this.cidType = cidType;
        this.cid = cid;
    }

    public String getProfileName() {
        return profileName;
    }

    public CidType getCidType() {
        return cidType;
    }

    public String getCid() {
        return cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cid cid1 = (Cid) o;

        if (cid != null ? !cid.equals(cid1.cid) : cid1.cid != null) return false;
        if (cidType != cid1.cidType) return false;
        if (profileName != null ? !profileName.equals(cid1.profileName) : cid1.profileName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = profileName != null ? profileName.hashCode() : 0;
        result = 31 * result + (cidType != null ? cidType.hashCode() : 0);
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cid{" +
                "profileName='" + profileName + '\'' +
                ", cidType=" + cidType +
                ", cid='" + cid + '\'' +
                '}';
    }
}

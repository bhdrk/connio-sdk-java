package com.connio.sdk.api.systemservices.devices.model;

import com.connio.sdk.api.model.GeoCoordinates;
import com.connio.sdk.api.model.Location;
import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import java.util.List;

import static com.connio.sdk.api.model.Method.GET;
import static com.connio.sdk.api.utils.TypeUtils.isNotEmpty;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class GetAllDeviceDetailsRequest extends DeviceRequest<GetAllDeviceDetailsResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        metaData.setMethod(GET);

        if (ownType != null) {
            metaData.addQueryParam("owntype", ownType.toString());
        }

        if (isNotEmpty(profileName)) {
            metaData.addQueryParam("profile", profileName);
        }

        if (isNotEmpty(subAccount)) {
            metaData.addQueryParam("subaccount", subAccount);
        }

        if (status != null) {
            metaData.addQueryParam("status", status.toString());
        }

        if (loc != null) {
            Asserts.notNull(loc.getName(), "Location.name");
            metaData.addQueryParam("locname", loc.getName());
        }

        if (loc != null && loc.getGeoCoord() != null) {
            GeoCoordinates geoCoord = loc.getGeoCoord();
            Asserts.notNull(geoCoord, "Location.geoCoord");
            Asserts.notNull(geoCoord.getLat(), "Location.geoCoord.lat");
            Asserts.notNull(geoCoord.getLon(), "Location.geoCoord.lon");
            Asserts.notNull(geoCoord.getRadius(), "Location.geoCoord.radius");
            metaData.addQueryParam("coord", "lat:" + geoCoord.getLat() + "+" + "lon:" + geoCoord.getLon() + "+" + "rad:" + geoCoord.getRadius());
        }

        if (isNotEmpty(tags)) {
            String t = "";
            for (String tag : tags) t += tag;
            metaData.addQueryParam("tags", t);
        }

        if (skip != null) {
            metaData.addQueryParam("skip", skip.toString());
        }

        if (limit != null) {
            metaData.addQueryParam("limit", limit.toString());
        }

        if (isNotEmpty(bookmark)) {
            metaData.addQueryParam("bookmark", bookmark);
        }
    }

    private DeviceOwnType ownType;

    private String profileName;

    private String subAccount;

    private DeviceStatusType status;

    private Location loc;

    private List<String> tags;

    private Integer skip;

    private Integer limit;

    private String bookmark;

    public DeviceOwnType getOwnType() {
        return ownType;
    }

    public void setOwnType(DeviceOwnType ownType) {
        this.ownType = ownType;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(String subAccount) {
        this.subAccount = subAccount;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getBookmark() {
        return bookmark;
    }

    public void setBookmark(String bookmark) {
        this.bookmark = bookmark;
    }
}

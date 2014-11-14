package com.connio.sdk.api.systemservices.deviceprofiles.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.PUT;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public class UpdateDeviceProfileRequest extends DeviceProfileRequest<UpdateDeviceProfileResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(profileSidOrName, "ProfileName or ProfileSid");
        Asserts.notNull(deviceProfile, "DeviceProfile");

        metaData.setMethod(PUT);
        metaData.addPath("/{profile}");
        metaData.addPathParam("profile", profileSidOrName);
        metaData.setRequestContent(deviceProfile);
    }

    private String profileSidOrName;

    private DeviceProfile deviceProfile;

    public UpdateDeviceProfileRequest() {
    }

    public UpdateDeviceProfileRequest(String profileSidOrName, DeviceProfile deviceProfile) {
        this.profileSidOrName = profileSidOrName;
        this.deviceProfile = deviceProfile;
    }

    public DeviceProfile getDeviceProfile() {
        return deviceProfile;
    }

    public void setDeviceProfile(DeviceProfile deviceProfile) {
        this.deviceProfile = deviceProfile;
    }

    public String getProfileSidOrName() {
        return profileSidOrName;
    }

    public void setProfileSidOrName(String profileSidOrName) {
        this.profileSidOrName = profileSidOrName;
    }
}

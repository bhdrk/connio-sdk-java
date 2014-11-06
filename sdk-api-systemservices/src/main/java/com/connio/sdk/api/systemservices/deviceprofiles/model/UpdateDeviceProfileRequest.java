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

        Asserts.notEmpty(deviceProfileName, "DeviceProfileName");
        Asserts.notNull(deviceProfile, "DeviceProfile");

        metaData.setMethod(PUT);
        metaData.addPath("/{device-profile-name}");
        metaData.addPathParam("device-profile-name", deviceProfileName);
        metaData.setRequestContent(deviceProfile);
    }

    private String deviceProfileName;

    private DeviceProfile deviceProfile;

    public UpdateDeviceProfileRequest() {
    }

    public UpdateDeviceProfileRequest(String deviceProfileName, DeviceProfile deviceProfile) {
        this.deviceProfileName = deviceProfileName;
        this.deviceProfile = deviceProfile;
    }

    public DeviceProfile getDeviceProfile() {
        return deviceProfile;
    }

    public void setDeviceProfile(DeviceProfile deviceProfile) {
        this.deviceProfile = deviceProfile;
    }

    public String getDeviceProfileName() {
        return deviceProfileName;
    }

    public void setDeviceProfileName(String deviceProfileName) {
        this.deviceProfileName = deviceProfileName;
    }
}

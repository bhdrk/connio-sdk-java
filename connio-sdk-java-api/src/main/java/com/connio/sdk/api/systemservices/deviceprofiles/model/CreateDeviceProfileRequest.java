package com.connio.sdk.api.systemservices.deviceprofiles.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.POST;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public class CreateDeviceProfileRequest extends DeviceProfileEndpointRequest<CreateDeviceProfileResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(deviceProfile, "DeviceProfile");

        metaData.setMethod(POST);
        metaData.setRequestContent(deviceProfile);
    }

    private DeviceProfile deviceProfile;

    public CreateDeviceProfileRequest() {
    }

    public CreateDeviceProfileRequest(DeviceProfile deviceProfile) {
        this.deviceProfile = deviceProfile;
    }

    public DeviceProfile getDeviceProfile() {
        return deviceProfile;
    }

    public void setDeviceProfile(DeviceProfile deviceProfile) {
        this.deviceProfile = deviceProfile;
    }
}

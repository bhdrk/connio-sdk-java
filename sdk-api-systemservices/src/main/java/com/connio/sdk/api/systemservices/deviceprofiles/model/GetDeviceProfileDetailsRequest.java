package com.connio.sdk.api.systemservices.deviceprofiles.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public class GetDeviceProfileDetailsRequest extends DeviceProfileRequest<GetDeviceProfileDetailsResponse> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(deviceProfileName, "DeviceProfileName");

        metaData.setMethod(GET);
        metaData.addPath("/{device-profile-name}");
        metaData.addPathParam("device-profile-name", deviceProfileName);
    }

    private String deviceProfileName;

    public GetDeviceProfileDetailsRequest() {
    }

    public GetDeviceProfileDetailsRequest(String deviceProfileName) {
        this.deviceProfileName = deviceProfileName;
    }

    public String getDeviceProfileName() {
        return deviceProfileName;
    }

    public void setDeviceProfileName(String deviceProfileName) {
        this.deviceProfileName = deviceProfileName;
    }
}

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

        Asserts.notEmpty(profileSidOrName, "ProfileName or ProfileSid");

        metaData.setMethod(GET);
        metaData.addPath("/{profile}");
        metaData.addPathParam("profile", profileSidOrName);
    }

    private String profileSidOrName;

    public GetDeviceProfileDetailsRequest() {
    }

    public GetDeviceProfileDetailsRequest(String profileSidOrName) {
        this.profileSidOrName = profileSidOrName;
    }

    public String getProfileSidOrName() {
        return profileSidOrName;
    }

    public void setProfileSidOrName(String profileSidOrName) {
        this.profileSidOrName = profileSidOrName;
    }
}

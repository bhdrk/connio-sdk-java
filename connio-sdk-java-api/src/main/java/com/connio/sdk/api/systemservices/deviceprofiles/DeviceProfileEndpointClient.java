package com.connio.sdk.api.systemservices.deviceprofiles;

import com.connio.sdk.api.core.ConnioEndpointClient;
import com.connio.sdk.api.systemservices.deviceprofiles.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public interface DeviceProfileEndpointClient extends ConnioEndpointClient {

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public GetAllDeviceProfileDetailsResponse getAllDeviceProfileDetails(GetAllDeviceProfileDetailsRequest request);

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public GetDeviceProfileDetailsResponse getDeviceProfileDetails(GetDeviceProfileDetailsRequest request);

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public CreateDeviceProfileResponse createDeviceProfile(CreateDeviceProfileRequest request);

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public UpdateDeviceProfileResponse updateDeviceProfile(UpdateDeviceProfileRequest request);

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public DeleteDeviceProfileResponse deleteDeviceProfile(DeleteDeviceProfileRequest request);
}

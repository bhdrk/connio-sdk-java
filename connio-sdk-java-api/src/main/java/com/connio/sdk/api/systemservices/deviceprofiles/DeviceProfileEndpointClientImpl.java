package com.connio.sdk.api.systemservices.deviceprofiles;

import com.connio.sdk.api.core.ConnioEndpointClientContext;
import com.connio.sdk.api.core.ConnioEndpointClientContextProvider;
import com.connio.sdk.api.systemservices.deviceprofiles.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public class DeviceProfileEndpointClientImpl implements DeviceProfileEndpointClient {

    private ConnioEndpointClientContext context;

    public DeviceProfileEndpointClientImpl() {
        context = ConnioEndpointClientContextProvider.get();
    }

    @Override
    public GetAllDeviceProfileDetailsResponse getAllDeviceProfileDetails(GetAllDeviceProfileDetailsRequest request) {
        return context.execute(request);
    }

    @Override
    public GetDeviceProfileDetailsResponse getDeviceProfileDetails(GetDeviceProfileDetailsRequest request) {
        return context.execute(request);
    }

    @Override
    public CreateDeviceProfileResponse createDeviceProfile(CreateDeviceProfileRequest request) {
        return context.execute(request);
    }

    @Override
    public UpdateDeviceProfileResponse updateDeviceProfile(UpdateDeviceProfileRequest request) {
        return context.execute(request);
    }

    @Override
    public DeleteDeviceProfileResponse deleteDeviceProfile(DeleteDeviceProfileRequest request) {
        return context.execute(request);
    }
}

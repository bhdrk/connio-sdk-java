package com.connio.sdk.api.systemservices.deviceprofiles;

import com.connio.sdk.api.core.AbstractClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.deviceprofiles.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 25.09.2014
 */
public class DeviceProfileClient extends AbstractClient implements IDeviceProfileClient {

    public DeviceProfileClient() {
    }

    public DeviceProfileClient(String credentialsProfile) {
        super(credentialsProfile);
    }

    /**
     * TODO: javadoc
     *
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceProfileResultSet getAllDeviceProfileDetails()
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetAllDeviceProfileDetailsRequest());
    }

    /**
     * TODO: javadoc
     *
     * @param deviceProfileName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceProfileDetails getDeviceProfileDetails(String deviceProfileName)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetDeviceProfileDetailsRequest(deviceProfileName));
    }

    /**
     * TODO: javadoc
     *
     * @param deviceProfile
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceProfileDetails createDeviceProfile(DeviceProfile deviceProfile)
            throws ConnioServiceException, ConnioClientException {
        return execute(new CreateDeviceProfileRequest(deviceProfile));
    }

    /**
     * TODO: javadoc
     *
     * @param deviceProfileName
     * @param deviceProfile
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceProfileDetails updateDeviceProfile(String deviceProfileName, DeviceProfile deviceProfile
    ) throws ConnioServiceException, ConnioClientException {
        return execute(new UpdateDeviceProfileRequest(deviceProfileName, deviceProfile));
    }

    /**
     * TODO: javadoc
     *
     * @param deviceProfileName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public Deleted deleteDeviceProfile(String deviceProfileName)
            throws ConnioServiceException, ConnioClientException {
        return execute(new DeleteDeviceProfileRequest(deviceProfileName));
    }
}

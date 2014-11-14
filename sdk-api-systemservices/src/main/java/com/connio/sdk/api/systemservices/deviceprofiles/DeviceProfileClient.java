package com.connio.sdk.api.systemservices.deviceprofiles;

import com.connio.sdk.api.core.AbstractClient;
import com.connio.sdk.api.core.ConnioClientTransformer;
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

    public DeviceProfileClient(String credentialsProfile, ConnioClientTransformer context) {
        super(credentialsProfile, context);
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
     * @param profileSidOrName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceProfileDetails getDeviceProfileDetails(String profileSidOrName)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetDeviceProfileDetailsRequest(profileSidOrName));
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
     * @param profileSidOrName
     * @param deviceProfile
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceProfileDetails updateDeviceProfile(String profileSidOrName, DeviceProfile deviceProfile
    ) throws ConnioServiceException, ConnioClientException {
        return execute(new UpdateDeviceProfileRequest(profileSidOrName, deviceProfile));
    }

    /**
     * TODO: javadoc
     *
     * @param profileSidOrName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public Deleted deleteDeviceProfile(String profileSidOrName)
            throws ConnioServiceException, ConnioClientException {
        return execute(new DeleteDeviceProfileRequest(profileSidOrName));
    }
}

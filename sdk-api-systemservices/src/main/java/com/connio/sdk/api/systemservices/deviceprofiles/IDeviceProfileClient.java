package com.connio.sdk.api.systemservices.deviceprofiles;

import com.connio.sdk.api.core.ConnioClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfile;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfileDetails;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfileResultSet;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public interface IDeviceProfileClient extends ConnioClient {

    /**
     * TODO: javadoc
     *
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public DeviceProfileResultSet getAllDeviceProfileDetails()
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param deviceProfileName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public DeviceProfileDetails getDeviceProfileDetails(String deviceProfileName)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param deviceProfile
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public DeviceProfileDetails createDeviceProfile(DeviceProfile deviceProfile)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param deviceProfileName
     * @param deviceProfile
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public DeviceProfileDetails updateDeviceProfile(String deviceProfileName, DeviceProfile deviceProfile)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param deviceProfileName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public Deleted deleteDeviceProfile(String deviceProfileName)
            throws ConnioServiceException, ConnioClientException;
}

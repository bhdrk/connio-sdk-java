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
     * @param profileSidOrName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public DeviceProfileDetails getDeviceProfileDetails(String profileSidOrName)
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
     * @param profileSidOrName
     * @param deviceProfile
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public DeviceProfileDetails updateDeviceProfile(String profileSidOrName, DeviceProfile deviceProfile)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param profileSidOrName
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public Deleted deleteDeviceProfile(String profileSidOrName)
            throws ConnioServiceException, ConnioClientException;
}

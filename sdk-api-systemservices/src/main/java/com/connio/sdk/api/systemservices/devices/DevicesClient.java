package com.connio.sdk.api.systemservices.devices;

import com.connio.sdk.api.core.AbstractClient;
import com.connio.sdk.api.core.ConnioClientTransformer;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.devices.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 29.09.2014
 */
public class DevicesClient extends AbstractClient implements IDevicesClient {

    public DevicesClient() {
    }

    public DevicesClient(String credentialsProfile) {
        super(credentialsProfile);
    }

    public DevicesClient(String credentialsProfile, ConnioClientTransformer context) {
        super(credentialsProfile, context);
    }

    /**
     * TODO: javadoc
     *
     * @param deviceSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceDetails getDeviceDetails(String deviceSid) throws ConnioServiceException, ConnioClientException {
        return execute(new GetDeviceDetailsBySIDRequest(deviceSid));
    }

    /**
     * TODO: javadoc
     *
     * @param deviceCid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceDetails getDeviceDetails(Cid deviceCid) throws ConnioServiceException, ConnioClientException {
        return execute(new GetDeviceDetailsByCIDRequest(deviceCid));
    }

    /**
     * TODO: javadoc
     *
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceResultSet getAllDeviceDetails() throws ConnioServiceException, ConnioClientException {
        return execute(new GetAllDeviceDetailsRequest());
    }

    /**
     * TODO: javadoc
     *
     * @param device
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceDetails createDevice(Device device) throws ConnioServiceException, ConnioClientException {
        return execute(new CreateDeviceRequest(device));
    }

    /**
     * TODO: javadoc
     *
     * @param deviceSid
     * @param device
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceDetails updateDevice(String deviceSid, Device device) throws ConnioServiceException, ConnioClientException {
        return execute(new UpdateDeviceBySIDRequest(deviceSid, device));
    }

    /**
     * TODO: javadoc
     *
     * @param deviceCid
     * @param device
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceDetails updateDevice(Cid deviceCid, Device device) throws ConnioServiceException, ConnioClientException {
        return execute(new UpdateDeviceByCIDRequest(deviceCid, device));
    }

    /**
     * TODO: javadoc
     *
     * @param deviceSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public Deleted deleteDevice(String deviceSid) throws ConnioServiceException, ConnioClientException {
        return execute(new DeleteDeviceBySIDRequest(deviceSid));
    }

    /**
     * TODO: javadoc
     *
     * @param deviceCid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public Deleted deleteDevice(Cid deviceCid) throws ConnioServiceException, ConnioClientException {
        return execute(new DeleteDeviceByCIDRequest(deviceCid));
    }

    /**
     * TODO: javadoc
     *
     * @param deviceSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceAccessKey regenerateAccessKey(String deviceSid) throws ConnioServiceException, ConnioClientException {
        return execute(new RegenerateAccessKeyBySIDRequest(deviceSid));
    }

    /**
     * TODO: javadoc
     *
     * @param deviceCid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceAccessKey regenerateAccessKey(Cid deviceCid) throws ConnioServiceException, ConnioClientException {
        return execute(new RegenerateAccessKeyByCIDRequest(deviceCid));
    }

    /**
     * TODO: javadoc
     *
     * @param deviceSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceAccessKey getAccessKey(String deviceSid) throws ConnioServiceException, ConnioClientException {
        return execute(new GetAccessKeyBySIDRequest(deviceSid));
    }

    /**
     * TODO: javadoc
     *
     * @param deviceCid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceAccessKey getAccessKey(Cid deviceCid) throws ConnioServiceException, ConnioClientException {
        return execute(new GetAccessKeyByCIDRequest(deviceCid));
    }
}

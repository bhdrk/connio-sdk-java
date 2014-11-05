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
     * @param sid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceDetails getDeviceDetails(String sid) throws ConnioServiceException, ConnioClientException {
        return execute(new GetDeviceDetailsBySIDRequest(sid));
    }

    /**
     * TODO: javadoc
     *
     * @param cid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceDetails getDeviceDetails(Cid cid) throws ConnioServiceException, ConnioClientException {
        return execute(new GetDeviceDetailsByCIDRequest(cid));
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
     * @param sid
     * @param device
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceDetails updateDevice(String sid, Device device) throws ConnioServiceException, ConnioClientException {
        return execute(new UpdateDeviceBySIDRequest(sid, device));
    }

    /**
     * TODO: javadoc
     *
     * @param cid
     * @param device
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceDetails updateDevice(Cid cid, Device device) throws ConnioServiceException, ConnioClientException {
        return execute(new UpdateDeviceByCIDRequest(cid, device));
    }

    /**
     * TODO: javadoc
     *
     * @param sid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public Deleted deleteDevice(String sid) throws ConnioServiceException, ConnioClientException {
        return execute(new DeleteDeviceBySIDRequest(sid));
    }

    /**
     * TODO: javadoc
     *
     * @param cid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public Deleted deleteDevice(Cid cid) throws ConnioServiceException, ConnioClientException {
        return execute(new DeleteDeviceByCIDRequest(cid));
    }

    /**
     * TODO: javadoc
     *
     * @param sid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceAccessKey generateAccessKey(String sid) throws ConnioServiceException, ConnioClientException {
        return execute(new GenerateAccessKeyBySIDRequest(sid));
    }

    /**
     * TODO: javadoc
     *
     * @param cid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceAccessKey generateAccessKey(Cid cid) throws ConnioServiceException, ConnioClientException {
        return execute(new GenerateAccessKeyByCIDRequest(cid));
    }

    /**
     * TODO: javadoc
     *
     * @param sid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceAccessKey getAccessKey(String sid) throws ConnioServiceException, ConnioClientException {
        return execute(new GetAccessKeyBySIDRequest(sid));
    }

    /**
     * TODO: javadoc
     *
     * @param cid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceAccessKey getAccessKey(Cid cid) throws ConnioServiceException, ConnioClientException {
        return execute(new GetAccessKeyByCIDRequest(cid));
    }
}

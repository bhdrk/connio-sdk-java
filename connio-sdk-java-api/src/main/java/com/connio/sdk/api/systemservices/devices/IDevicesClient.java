package com.connio.sdk.api.systemservices.devices;

import com.connio.sdk.api.core.ConnioClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.devices.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public interface IDevicesClient extends ConnioClient {

    /**
     * TODO: javadoc
     *
     * @param sid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public DeviceDetails getDeviceDetails(String sid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param cid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public DeviceDetails getDeviceDetails(Cid cid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public DeviceResultSet getAllDeviceDetails()
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param device
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public DeviceDetails createDevice(Device device)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param sid
     * @param device
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public DeviceDetails updateDevice(String sid, Device device)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param cid
     * @param device
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public DeviceDetails updateDevice(Cid cid, Device device)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param sid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public Deleted deleteDevice(String sid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param cid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public Deleted deleteDevice(Cid cid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param sid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public DeviceAccessKey generateAccessKey(String sid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param cid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public DeviceAccessKey generateAccessKey(Cid cid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param sid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public DeviceAccessKey getAccessKey(String sid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param cid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public DeviceAccessKey getAccessKey(Cid cid)
            throws ConnioServiceException, ConnioClientException;
}

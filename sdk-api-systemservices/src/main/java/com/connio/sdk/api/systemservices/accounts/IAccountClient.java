package com.connio.sdk.api.systemservices.accounts;

import com.connio.sdk.api.core.ConnioClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.accounts.model.*;
import com.connio.sdk.api.systemservices.apps.model.AppResultSet;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfileResultSet;
import com.connio.sdk.api.systemservices.devices.model.DeviceResultSet;
import com.connio.sdk.api.systemservices.users.model.UserResultSet;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public interface IAccountClient extends ConnioClient {

    /**
     * TODO: javadoc
     *
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public AccountDetails getMyAccountDetails()
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public SubAccountDetails getSubAccountDetails(String accountSid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public SubAccountResultSet getAllSubAccountDetails()
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param subAccount
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public SubAccountDetails createSubAccount(SubAccount subAccount)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @param subAccount
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public SubAccountDetails updateSubAccount(String accountSid, SubAccount subAccount)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public Deleted deleteSubAccount(String accountSid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public AuthToken regenerateAuthenticationToken(String accountSid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public BillingInfoList getBillingInfo(String accountSid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public UserResultSet getUsersOfAccount(String accountSid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public AppResultSet getAppsOfAccount(String accountSid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public DeviceResultSet getDevicesOfAccount(String accountSid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    public DeviceProfileResultSet getDeviceProfilesOfAccount(String accountSid)
            throws ConnioServiceException, ConnioClientException;
}

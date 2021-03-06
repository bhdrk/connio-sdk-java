package com.connio.sdk.api.systemservices.accounts;

import com.connio.sdk.api.core.AbstractClient;
import com.connio.sdk.api.core.ConnioClientTransformer;
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
 * @since 15.09.2014
 */
public class AccountClient extends AbstractClient implements IAccountClient {

    public AccountClient() {
    }

    public AccountClient(String credentialsProfile) {
        super(credentialsProfile);
    }

    public AccountClient(String credentialsProfile, ConnioClientTransformer context) {
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
    public AccountDetails getMyAccountDetails()
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetMyAccountDetailsRequest());
    }

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public SubAccountDetails getSubAccountDetails(String accountSid)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetSubAccountDetailsRequest(accountSid));
    }

    /**
     * TODO: javadoc
     *
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public SubAccountResultSet getAllSubAccountDetails()
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetAllSubAccountsDetailsRequest());
    }

    /**
     * TODO: javadoc
     *
     * @param subAccount
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public SubAccountDetails createSubAccount(SubAccount subAccount)
            throws ConnioServiceException, ConnioClientException {
        return execute(new CreateSubAccountRequest(subAccount));
    }

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @param subAccount
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public SubAccountDetails updateSubAccount(String accountSid, SubAccount subAccount)
            throws ConnioServiceException, ConnioClientException {
        return execute(new UpdateSubAccountRequest(accountSid, subAccount));
    }

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public Deleted deleteSubAccount(String accountSid)
            throws ConnioServiceException, ConnioClientException {
        return execute(new DeleteSubAccountRequest(accountSid));
    }

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public AuthToken regenerateAuthenticationToken(String accountSid)
            throws ConnioServiceException, ConnioClientException {
        return execute(new RegenerateAuthenticationTokenRequest(accountSid));
    }

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public BillingInfoList getBillingInfo(String accountSid)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetBillingInfoRequest(accountSid));
    }

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public UserResultSet getUsersOfAccount(String accountSid)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetUsersOfAccountRequest(accountSid));
    }

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public AppResultSet getAppsOfAccount(String accountSid)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetAppsOfAccountRequest(accountSid));
    }

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceResultSet getDevicesOfAccount(String accountSid)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetDevicesOfAccountRequest(accountSid));
    }

    /**
     * TODO: javadoc
     *
     * @param accountSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public DeviceProfileResultSet getDeviceProfilesOfAccount(String accountSid)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetDeviceProfilesOfAccountRequest(accountSid));
    }
}

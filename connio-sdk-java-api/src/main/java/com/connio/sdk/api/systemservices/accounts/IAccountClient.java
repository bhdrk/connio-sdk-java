package com.connio.sdk.api.systemservices.accounts;

import com.connio.sdk.api.core.ConnioClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.accounts.model.*;

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
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public AccountDetails getMyAccountDetails()
            throws ConnioServiceException, ConnioClientException;

    /**
     * @param sid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public SubAccountDetails getSubAccountDetails(String sid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public SubAccountResultSet getAllSubAccountDetails()
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param subAccount
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public SubAccountDetails createSubAccount(SubAccount subAccount)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param sid
     * @param subAccount
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public SubAccountDetails updateSubAccount(String sid, SubAccount subAccount)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param sid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public Deleted deleteSubAccount(String sid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param sid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public AuthToken createAuthenticationToken(String sid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param sid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public BillingInfoList getBillingInfo(String sid)
            throws ConnioServiceException, ConnioClientException;
}

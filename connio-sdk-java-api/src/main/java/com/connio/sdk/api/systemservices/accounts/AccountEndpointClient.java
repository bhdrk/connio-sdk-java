package com.connio.sdk.api.systemservices.accounts;

import com.connio.sdk.api.core.AbstractEndpointClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.accounts.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 15.09.2014
 */
public class AccountEndpointClient extends AbstractEndpointClient implements IAccountEndpointClient {

    /**
     * TODO: javadoc
     *
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public AccountDetails getMyAccountDetails()
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetMyAccountDetailsRequest());
    }

    /**
     * TODO: javadoc
     *
     * @param sid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public SubAccountDetails getSubAccountDetails(String sid)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetSubAccountDetailsRequest(sid));
    }

    /**
     * TODO: javadoc
     *
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
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
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public SubAccountDetails createSubAccount(SubAccount subAccount)
            throws ConnioServiceException, ConnioClientException {
        return execute(new CreateSubAccountRequest(subAccount));
    }

    /**
     * TODO: javadoc
     *
     * @param sid
     * @param subAccount
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public SubAccountDetails updateSubAccount(String sid, SubAccount subAccount)
            throws ConnioServiceException, ConnioClientException {
        return execute(new UpdateSubAccountRequest(sid, subAccount));
    }

    /**
     * TODO: javadoc
     *
     * @param sid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public Deleted deleteSubAccount(String sid)
            throws ConnioServiceException, ConnioClientException {
        return execute(new DeleteSubAccountRequest(sid));
    }

    /**
     * TODO: javadoc
     *
     * @param sid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public AuthToken createAuthenticationToken(String sid)
            throws ConnioServiceException, ConnioClientException {
        return execute(new CreateAuthenticationTokenRequest(sid));
    }

    /**
     * TODO: javadoc
     *
     * @param sid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public BillingInfoList getBillingInfo(String sid)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetBillingInfoRequest(sid));
    }
}

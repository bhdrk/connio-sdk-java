package com.connio.sdk.api.systemservices.accounts;

import com.connio.sdk.api.core.ConnioEndpointClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.systemservices.accounts.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public interface AccountEndpointClient extends ConnioEndpointClient {

    /**
     * TODO: javadoc
     *
     * @return
     */
    public GetMyAccountDetailsResponse getMyAccountDetails(GetMyAccountDetailsRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public GetSubAccountDetailsResponse getSubAccountDetails(GetSubAccountDetailsRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @return
     */
    public GetAllSubAccountsDetailsResponse getAllSubAccountDetails(GetAllSubAccountsDetailsRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public CreateSubAccountResponse createSubAccount(CreateSubAccountRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public UpdateSubAccountResponse updateSubAccount(UpdateSubAccountRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public DeleteSubAccountResponse deleteSubAccount(DeleteSubAccountRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public CreateAuthenticationTokenResponse createAuthenticationToken(CreateAuthenticationTokenRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public GetBillingInfoResponse getBillingInfo(GetBillingInfoRequest request)
            throws ConnioServiceException, ConnioClientException;
}

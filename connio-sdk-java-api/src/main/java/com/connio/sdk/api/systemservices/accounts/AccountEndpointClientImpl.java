package com.connio.sdk.api.systemservices.accounts;

import com.connio.sdk.api.core.ConnioEndpointClientContext;
import com.connio.sdk.api.core.ConnioEndpointClientContextProvider;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.systemservices.accounts.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 15.09.2014
 */
public class AccountEndpointClientImpl implements AccountEndpointClient {

    private ConnioEndpointClientContext context;

    public AccountEndpointClientImpl() {
        this.context = ConnioEndpointClientContextProvider.get();
    }

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public GetMyAccountDetailsResponse getMyAccountDetails(GetMyAccountDetailsRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request, GetMyAccountDetailsResponse.class);
    }

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public GetSubAccountDetailsResponse getSubAccountDetails(GetSubAccountDetailsRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request, GetSubAccountDetailsResponse.class);
    }

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public GetAllSubAccountsDetailsResponse getAllSubAccountDetails(GetAllSubAccountsDetailsRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request, GetAllSubAccountsDetailsResponse.class);
    }

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public CreateSubAccountResponse createSubAccount(CreateSubAccountRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request, CreateSubAccountResponse.class);
    }

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public UpdateSubAccountResponse updateSubAccount(UpdateSubAccountRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request, UpdateSubAccountResponse.class);
    }

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public DeleteSubAccountResponse deleteSubAccount(DeleteSubAccountRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request, DeleteSubAccountResponse.class);
    }

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public CreateAuthenticationTokenResponse createAuthenticationToken(CreateAuthenticationTokenRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request, CreateAuthenticationTokenResponse.class);
    }

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public GetBillingInfoResponse getBillingInfo(GetBillingInfoRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request, GetBillingInfoResponse.class);
    }
}

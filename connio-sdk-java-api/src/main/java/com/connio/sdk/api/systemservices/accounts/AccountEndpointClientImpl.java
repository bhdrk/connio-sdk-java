package com.connio.sdk.api.systemservices.accounts;

import com.connio.sdk.api.core.ConnioEndpointClientContext;
import com.connio.sdk.api.core.ConnioEndpointClientContextProvider;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioEndpointException;
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
        context = ConnioEndpointClientContextProvider.get();
    }

    @Override
    public GetMyAccountDetailsResponse getMyAccountDetails(GetMyAccountDetailsRequest request)
            throws ConnioEndpointException, ConnioClientException {
        return context.execute(request, GetMyAccountDetailsResponse.class);
    }

    @Override
    public GetSubAccountDetailsResponse getSubAccountDetails(GetSubAccountDetailsRequest request)
            throws ConnioEndpointException, ConnioClientException {
        return context.execute(request, GetSubAccountDetailsResponse.class);
    }

    @Override
    public GetAllSubAccountsDetailsResponse getAllSubAccountDetails(GetAllSubAccountsDetailsRequest request)
            throws ConnioEndpointException, ConnioClientException {
        return context.execute(request, GetAllSubAccountsDetailsResponse.class);
    }

    @Override
    public CreateSubAccountResponse createSubAccount(CreateSubAccountRequest request)
            throws ConnioEndpointException, ConnioClientException {
        return context.execute(request, CreateSubAccountResponse.class);
    }

    @Override
    public UpdateSubAccountResponse updateSubAccount(UpdateSubAccountRequest request)
            throws ConnioEndpointException, ConnioClientException {
        return context.execute(request, UpdateSubAccountResponse.class);
    }

    @Override
    public DeleteSubAccountResponse deleteSubAccount(DeleteSubAccountRequest request)
            throws ConnioEndpointException, ConnioClientException {
        return context.execute(request, DeleteSubAccountResponse.class);
    }

    @Override
    public CreateAuthenticationTokenResponse createAuthenticationToken(CreateAuthenticationTokenRequest request)
            throws ConnioEndpointException, ConnioClientException {
        return context.execute(request, CreateAuthenticationTokenResponse.class);
    }

    @Override
    public GetBillingInfoResponse getBillingInfo(GetBillingInfoRequest request)
            throws ConnioEndpointException, ConnioClientException {
        return context.execute(request, GetBillingInfoResponse.class);
    }
}

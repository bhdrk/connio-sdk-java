package com.connio.sdk.api.systemservices.users;

import com.connio.sdk.api.core.ConnioEndpointClientContext;
import com.connio.sdk.api.core.ConnioEndpointClientContextProvider;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.systemservices.users.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 18.09.2014
 */
public class UserEndpointClientImpl implements UserEndpointClient {

    private ConnioEndpointClientContext context;

    public UserEndpointClientImpl() {
        context = ConnioEndpointClientContextProvider.get();
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
    public GetUserDetailsResponse getUserDetails(GetUserDetailsRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request);
    }

    /**
     * TODO: javadoc
     *
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    @Override
    public GetAllUserDetailsResponse getAllUserDetails(GetAllUserDetailsRequest request)
            throws ConnioServiceException, ConnioClientException {
        return context.execute(request);
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
    public CreateUserResponse createUser(CreateUserRequest request)
            throws ConnioServiceException, ConnioClientException {
        throw new ConnioClientException("Unsupported Operation.");
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
    public UpdateUserResponse updateUser(UpdateUserRequest request)
            throws ConnioServiceException, ConnioClientException {
        throw new ConnioClientException("Unsupported Operation.");
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
    public DeleteUserResponse deleteUser(DeleteUserRequest request)
            throws ConnioServiceException, ConnioClientException {
        throw new ConnioClientException("Unsupported Operation.");
    }
}

package com.connio.sdk.api.systemservices.users;

import com.connio.sdk.api.core.ConnioEndpointClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.systemservices.users.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 10.09.2014
 */
public interface UserEndpointClient extends ConnioEndpointClient {

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public GetUserDetailsResponse getUserDetails(GetUserDetailsRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @return
     */
    public GetAllUserDetailsResponse getAllUserDetails()
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public CreateUserResponse createUser(CreateUserRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public UpdateUserResponse updateUser(UpdateUserRequest request)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param request
     * @return
     */
    public DeleteUserResponse deleteUser(DeleteUserRequest request)
            throws ConnioServiceException, ConnioClientException;
}

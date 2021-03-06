package com.connio.sdk.api.systemservices.users;

import com.connio.sdk.api.core.AbstractClient;
import com.connio.sdk.api.core.ConnioClientTransformer;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.users.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 18.09.2014
 */
public class UserClient extends AbstractClient implements IUserClient {

    public UserClient() {
    }

    public UserClient(String credentialsProfile) {
        super(credentialsProfile);
    }

    public UserClient(String credentialsProfile, ConnioClientTransformer context) {
        super(credentialsProfile, context);
    }

    /**
     * TODO: javadoc
     *
     * @param userSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public UserDetails getUserDetails(String userSid)
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetUserDetailsRequest(userSid));
    }

    /**
     * TODO: javadoc
     *
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public UserResultSet getAllUserDetails()
            throws ConnioServiceException, ConnioClientException {
        return execute(new GetAllUserDetailsRequest());
    }

    /**
     * TODO: javadoc
     *
     * @param user
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public UserDetails createUser(User user)
            throws ConnioServiceException, ConnioClientException {
        return execute(new CreateUserRequest(user));
    }

    /**
     * TODO: javadoc
     *
     * @param userSid
     * @param user
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public UserDetails updateUser(String userSid, User user)
            throws ConnioServiceException, ConnioClientException {
        return execute(new UpdateUserRequest(userSid, user));
    }

    /**
     * TODO: javadoc
     *
     * @param userSid
     * @return
     * @throws com.connio.sdk.api.exception.ConnioServiceException
     * @throws com.connio.sdk.api.exception.ConnioClientException
     */
    @Override
    public Deleted deleteUser(String userSid)
            throws ConnioServiceException, ConnioClientException {
        return execute(new DeleteUserRequest(userSid));
    }
}

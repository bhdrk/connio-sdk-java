package com.connio.sdk.api.systemservices.users;

import com.connio.sdk.api.core.ConnioEndpointClient;
import com.connio.sdk.api.exception.ConnioClientException;
import com.connio.sdk.api.exception.ConnioServiceException;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.users.model.User;
import com.connio.sdk.api.systemservices.users.model.UserDetails;
import com.connio.sdk.api.systemservices.users.model.UserResultSet;

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
     * @param userSid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public UserDetails getUserDetails(String userSid)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public UserResultSet getAllUserDetails()
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param user
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public UserDetails createUser(User user)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param userSid
     * @param user
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public UserDetails updateUser(String userSid, User user)
            throws ConnioServiceException, ConnioClientException;

    /**
     * TODO: javadoc
     *
     * @param userSid
     * @return
     * @throws ConnioServiceException
     * @throws ConnioClientException
     */
    public Deleted deleteUser(String userSid)
            throws ConnioServiceException, ConnioClientException;
}

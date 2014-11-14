package com.connio.sdk.api.systemservices.users.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.PUT;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class UpdateUserRequest extends UserRequest<UpdateUserResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(userSid, "UserSid");
        Asserts.notNull(user, "User");

        metaData.setMethod(PUT);
        metaData.addPath("/{sid}");
        metaData.addPathParam("sid", userSid);
        metaData.setRequestContent(user);
    }

    private String userSid;

    private User user;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String userSid, User user) {
        this.userSid = userSid;
        this.user = user;
    }

    public String getUserSid() {
        return userSid;
    }

    public void setUserSid(String userSid) {
        this.userSid = userSid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

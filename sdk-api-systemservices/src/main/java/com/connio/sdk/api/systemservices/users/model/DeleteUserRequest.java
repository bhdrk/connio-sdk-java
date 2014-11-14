package com.connio.sdk.api.systemservices.users.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.DELETE;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class DeleteUserRequest extends UserRequest<DeleteUserResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(userSid, "UserSid");

        metaData.setMethod(DELETE);
        metaData.addPath("/{sid}");
        metaData.addPathParam("sid", userSid);
    }

    private String userSid;

    public DeleteUserRequest() {
    }

    public DeleteUserRequest(String userSid) {
        this.userSid = userSid;
    }

    public String getUserSid() {
        return userSid;
    }

    public void setUserSid(String userSid) {
        this.userSid = userSid;
    }
}

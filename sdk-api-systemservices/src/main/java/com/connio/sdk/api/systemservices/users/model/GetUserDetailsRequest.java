package com.connio.sdk.api.systemservices.users.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.GET;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class GetUserDetailsRequest extends UserRequest<GetUserDetailsResponse> {
    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notEmpty(userSid, "UserSid");

        metaData.setMethod(GET);
        metaData.addPath("/{user-sid}");
        metaData.addPathParam("user-sid", userSid);
    }

    /**
     * TODO: javadoc
     */
    private String userSid;

    public GetUserDetailsRequest() {
    }

    public GetUserDetailsRequest(String userSid) {
        this.userSid = userSid;
    }

    public String getUserSid() {
        return userSid;
    }

    public void setUserSid(String userSid) {
        this.userSid = userSid;
    }
}

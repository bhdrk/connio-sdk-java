package com.connio.sdk.api.systemservices.users.model;

import com.connio.sdk.api.model.RequestMetaData;
import com.connio.sdk.api.utils.Asserts;

import static com.connio.sdk.api.model.Method.POST;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class CreateUserRequest extends UserRequest<CreateUserResponse> {

    @Override
    public void loadMetaData(RequestMetaData metaData) {
        super.loadMetaData(metaData);

        Asserts.notNull(user, "User");

        metaData.setMethod(POST);
        metaData.setRequestContent(user);
    }

    private User user;

    public CreateUserRequest() {
    }

    public CreateUserRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

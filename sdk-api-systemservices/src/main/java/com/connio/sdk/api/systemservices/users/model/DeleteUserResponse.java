package com.connio.sdk.api.systemservices.users.model;

import com.connio.sdk.api.model.Deleted;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 11.09.2014
 */
public class DeleteUserResponse extends UserResponse<Deleted> {

    /**
     * TODO: javadoc
     */
    private Deleted result;

    @Override
    public Deleted getResult() {
        return result;
    }

    @Override
    public void setResult(Deleted result) {
        this.result = result;
    }
}

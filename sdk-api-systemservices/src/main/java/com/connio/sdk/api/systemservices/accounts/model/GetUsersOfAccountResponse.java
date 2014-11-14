package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.systemservices.users.model.UserResultSet;

/**
 * Created by bdirik on 13.11.2014.
 */
public class GetUsersOfAccountResponse extends AccountResponse<UserResultSet> {

    private UserResultSet result;

    public GetUsersOfAccountResponse() {
    }

    public GetUsersOfAccountResponse(UserResultSet result) {
        this.result = result;
    }

    @Override
    public UserResultSet getResult() {
        return result;
    }

    @Override
    public void setResult(UserResultSet result) {
        this.result = result;
    }
}

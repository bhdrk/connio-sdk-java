package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfileResultSet;

/**
 * Created by bdirik on 13.11.2014.
 */
public class GetDeviceProfilesOfAccountResponse extends AccountResponse<DeviceProfileResultSet> {

    private DeviceProfileResultSet result;

    public GetDeviceProfilesOfAccountResponse() {
    }

    public GetDeviceProfilesOfAccountResponse(DeviceProfileResultSet result) {
        this.result = result;
    }

    @Override
    public DeviceProfileResultSet getResult() {
        return result;
    }

    @Override
    public void setResult(DeviceProfileResultSet result) {
        this.result = result;
    }
}

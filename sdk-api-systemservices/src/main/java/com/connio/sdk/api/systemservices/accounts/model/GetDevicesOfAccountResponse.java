package com.connio.sdk.api.systemservices.accounts.model;

import com.connio.sdk.api.systemservices.devices.model.DeviceResultSet;

/**
 * Created by bdirik on 13.11.2014.
 */
public class GetDevicesOfAccountResponse extends AccountResponse<DeviceResultSet> {

    private DeviceResultSet result;

    public GetDevicesOfAccountResponse() {
    }

    public GetDevicesOfAccountResponse(DeviceResultSet result) {
        this.result = result;
    }

    @Override
    public DeviceResultSet getResult() {
        return result;
    }

    @Override
    public void setResult(DeviceResultSet result) {
        this.result = result;
    }
}

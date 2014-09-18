package com.connio.sdk.http;

import com.connio.sdk.api.auth.ConnioBasicCredentials;
import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.auth.ConnioCredentialsManager;
import com.connio.sdk.api.systemservices.accounts.AccountEndpointClient;
import com.connio.sdk.api.systemservices.accounts.AccountEndpointClientImpl;
import com.connio.sdk.api.systemservices.accounts.model.*;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 17.09.2014
 */
public class App {
    public static void main(String[] args) {
        ConnioCredentials credentials = new ConnioBasicCredentials("accesskey", "secretkey");
        ConnioCredentialsManager.setCredentials(credentials);

        AccountEndpointClient client = new AccountEndpointClientImpl();

        SubAccount subAccount = new SubAccount();
        subAccount.setDisplayName("TEST");
        subAccount.setPlanType(PlanType.ENTERPRISE);
        subAccount.setStatus(StatusType.CREATED);

        CreateSubAccountRequest request = new CreateSubAccountRequest(subAccount);
        CreateSubAccountResponse response = client.createSubAccount(request);
        System.out.println(response.getResult().toString());
    }
}

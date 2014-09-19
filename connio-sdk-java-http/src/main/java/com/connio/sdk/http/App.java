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
        ConnioCredentials credentials = new ConnioBasicCredentials("AC739E3716D10E47A89C6C972FF97B5852", "f017ea800e884136b767e366749f8796");
        ConnioCredentialsManager.setCredentials(credentials);

        AccountEndpointClient client = new AccountEndpointClientImpl();

        String subAccountSid = "AC332B14995A994D44944175953798B674";

        SubAccount subAccount = new SubAccount();
        subAccount.setDisplayName("T111");

        UpdateSubAccountRequest request = new UpdateSubAccountRequest(subAccountSid, subAccount);
        UpdateSubAccountResponse response = client.updateSubAccount(request);
        System.out.println(response.getResult());
    }
}

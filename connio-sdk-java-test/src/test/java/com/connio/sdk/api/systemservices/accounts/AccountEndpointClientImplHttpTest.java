package com.connio.sdk.api.systemservices.accounts;

import com.connio.sdk.api.auth.ConnioCredentialsManager;
import com.connio.sdk.api.systemservices.accounts.model.AccountDetails;
import com.connio.sdk.api.systemservices.accounts.model.GetMyAccountDetailsRequest;
import com.connio.sdk.api.systemservices.accounts.model.GetMyAccountDetailsResponse;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 22.09.2014
 */
public class AccountEndpointClientImplHttpTest {

    private AccountEndpointClientImpl client;

    @Before
    public void setUp() throws Exception {
        client = new AccountEndpointClientImpl();
    }

    @Test
    public void testGetMyAccountDetails() throws Exception {
        GetMyAccountDetailsRequest request = new GetMyAccountDetailsRequest();

        GetMyAccountDetailsResponse response = client.getMyAccountDetails(request);
        AccountDetails result = response.getResult();

        String accountSid = result.getSid();
        String currentAccountSid = ConnioCredentialsManager.getCredentials().getAccessKey();

        assertThat(accountSid).isEqualTo(currentAccountSid);
    }

}

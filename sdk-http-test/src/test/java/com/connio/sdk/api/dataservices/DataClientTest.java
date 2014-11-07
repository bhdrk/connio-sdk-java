package com.connio.sdk.api.dataservices;

import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.core.AbstractClientMockServerTestCase;
import com.connio.sdk.api.dataservices.model.*;
import com.connio.sdk.api.model.GeoCoordinates;
import com.connio.sdk.api.model.Location;
import com.connio.sdk.http.json.JSON;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.connio.sdk.api.systemservices.TestUtils.resource;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 20.10.2014.
 */
@Test(suiteName = "ClientTest")
public class DataClientTest extends AbstractClientMockServerTestCase {

    private IDataClient dataClient;

    @BeforeClass
    public void beforeClass() throws Exception {
        dataClient = new DataClient(ConnioCredentials.DEFAULT_PROFILE, mockTransformer());
    }

    @Test
    public void testSendDataToApp() throws Exception {
        final String expectedRequestJson = resource("json/dataservices/sendData/toAppRequest.json");
        final String mockResponseJson = resource("json/dataservices/sendData/toAppResponse.json");

        pushResponse(mockResponseJson);

        DataFeed dataFeed = new DataFeed();
        dataFeed.setId_("10029");
        dataFeed.setLoc_(new Location("Istanbul", new GeoCoordinates(41.00527D, 28.976959999999963D)));
        dataFeed.setSrcUri_("_devices/_id/900056");
        dataFeed.setTags_(Arrays.asList("TAG1", "TAG2"));

        dataFeed.addDataPoint(new DataPoint(1415190143712L, 25, "ACHAN"));
        dataFeed.addDataPoint(new DataPoint(1415190143712L, "Lorem", "BCHAN"));
        dataFeed.addDataPoint(new DataPoint(1415190143712L, 950.5, "CCHAN"));

        String appName = "TESTAPP";

        DataFeedDetails result = dataClient.sendData(appName, dataFeed);
        DataFeedDetails expectedResult = JSON.fromString(mockResponseJson, DataFeedDetails.class);

        assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/v1/_apps/" + appName + "/_data");
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testSendDataToChannel() throws Exception {
        final String expectedRequestJson = resource("json/dataservices/sendData/toChannelRequest.json");
        final String mockResponseJson = resource("json/dataservices/sendData/toChannelResponse.json");

        pushResponse(mockResponseJson);

        DataFeed dataFeed = new DataFeed();
        dataFeed.setId_("10029");
        dataFeed.setLoc_(new Location("Istanbul", new GeoCoordinates(41.00527D, 28.976959999999963D)));
        dataFeed.setSrcUri_("_devices/_id/900056");
        dataFeed.setTags_(Arrays.asList("TAG1", "TAG2"));

        dataFeed.addDataPoint(new DataPoint(1415190143712L, 25));
        dataFeed.addDataPoint(new DataPoint(1415190143712L, "Lorem"));
        dataFeed.addDataPoint(new DataPoint(1415190143712L, 950.5));

        String appName = "TESTAPP";
        String channelName = "CHAN";

        DataFeedDetails result = dataClient.sendData(appName, channelName, dataFeed);
        DataFeedDetails expectedResult = JSON.fromString(mockResponseJson, DataFeedDetails.class);

        assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/v1/_apps/" + appName + "/_data/" + channelName);
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testGetData() throws Exception {
        final String mockResponseJson = resource("json/dataservices/getData/response.json");

        pushResponse(mockResponseJson);

        String appName = "TESTAPP";
        String channelName = "CHAN";

        DataQuery dataQuery = new DataQuery("device.id:1DAC8BAF8966ED4A2AB32E3D642E7DB671", 0, 10, "", "-client.time");

        DataPointResultSet result = dataClient.getData(appName, channelName, dataQuery);
        DataPointResultSet expectedResult = JSON.fromString(mockResponseJson, DataPointResultSet.class);

        assertThat(result).isEqualTo(expectedResult);

        Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_apps/" + appName + "/_data/" + channelName + "?limit=10&skip=0&query=device.id%253A1DAC8BAF8966ED4A2AB32E3D642E7DB671&sort=-client.time");
    }
}

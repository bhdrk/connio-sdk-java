package com.connio.sdk.api.dataservices;

import com.connio.sdk.api.AbstractClientMockServerTestCase;
import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.dataservices.model.*;
import com.connio.sdk.api.model.GeoCoordinates;
import com.connio.sdk.api.model.Location;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.connio.sdk.api.TestUtils.resource;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 20.10.2014.
 */
@Test(suiteName = "ClientTests", groups = "client")
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


        final DataFeed requestContent = new DataFeed();
        requestContent.setId_("10029");
        requestContent.setLoc_(new Location("Istanbul", new GeoCoordinates(41.00527D, 28.976959999999963D)));
        requestContent.setSrcUri_("_devices/_id/900056");
        requestContent.setTags_(Arrays.asList("TAG1", "TAG2"));
        requestContent.setChan_("ATM.Temperature");

        requestContent.addDataPoint(new DataPoint(1415190143700L, 25));
        requestContent.addDataPoint(new DataPoint(1415190143800L, 26));
        requestContent.addDataPoint(new DataPoint(1415190143900L, 27.5));

        final DataPoint dataPoint = new DataPoint(1415190143995L, "UPS OFF", "ATM.UPS");
        dataPoint.setFeedId_("10030");
        dataPoint.setLoc_(new Location("Istanbul Taksim", new GeoCoordinates(41.036565D, 28.98690899999997D)));
        dataPoint.setSrcUri_("_devices/_id/900057");
        dataPoint.setTags_(Arrays.asList("TAG3"));

        requestContent.addDataPoint(dataPoint);

        final DataFeedDetails expectedResult = new DataFeedDetails();

        expectedResult.setAccepted(4);
        expectedResult.setRejected(0);


        pushResponse(mockResponseJson);

        final String appName = "BANK";

        final DataFeedDetails result = dataClient.sendData(appName, requestContent);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/v1/_apps/" + appName + "/_data");
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testSendDataToChannel() throws Exception {
        final String expectedRequestJson = resource("json/dataservices/sendData/toChannelRequest.json");
        final String mockResponseJson = resource("json/dataservices/sendData/toChannelResponse.json");


        final DataPoint dataPoint1 = new DataPoint(1415190143995L, 25.5);
        dataPoint1.setFeedId_("1000");
        dataPoint1.setLoc_(new Location("Istanbul", new GeoCoordinates(41.00527D, 28.976959999999963D)));
        dataPoint1.setSrcUri_("_devices/_id/900057");
        dataPoint1.setTags_(Collections.<String>emptyList());

        final DataPoint dataPoint2 = new DataPoint(1415190143990L, 28);
        dataPoint2.setFeedId_("1000");
        dataPoint2.setLoc_(new Location("Izmir", new GeoCoordinates(38.41885D, 27.12871999999993D)));
        dataPoint2.setSrcUri_("_devices/_id/900060");
        dataPoint2.setTags_(Collections.<String>emptyList());

        final DataFeed requestContent = new DataFeed();
        requestContent.addDataPoint(dataPoint1);
        requestContent.addDataPoint(dataPoint2);

        final DataFeedDetails expectedResult = new DataFeedDetails();

        expectedResult.setAccepted(2);
        expectedResult.setRejected(0);


        pushResponse(mockResponseJson);

        String appName = "BANK";
        String channelName = "ATM.Temperature";

        DataFeedDetails result = dataClient.sendData(appName, channelName, requestContent);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("POST");
        assertThat(request.getPath()).isEqualTo("/v1/_apps/" + appName + "/_data/" + channelName);
        assertThat(request.getBody()).isEqualTo(expectedRequestJson);
    }

    @Test
    public void testGetData() throws Exception {
        final String mockResponseJson = resource("json/dataservices/getData/response.json");


        final DataPointDetails details1 = new DataPointDetails();
        details1.setTime(1415190143995L);
        details1.setValue(25.5);
        details1.setFeedId_("1000");
        details1.setLoc_(new Location("Istanbul", new GeoCoordinates(41.00527D, 28.976959999999963D)));
        details1.setSrcUri_("_devices/1DAC8BAF8966ED4A2AB32E3D642E7DB671");
        details1.setTags_(Collections.<String>emptyList());
        details1.setChan_("9C8E635FAAB9F14EB786E7A44091D711A6");
        details1.setSrvTime_(1415190144000L);
        details1.setRemIp_("10.10.10.11");

        final DataPointDetails details2 = new DataPointDetails();
        details2.setTime(1415190143990L);
        details2.setValue(28);
        details2.setFeedId_("1000");
        details2.setLoc_(new Location("Izmir", new GeoCoordinates(38.41885D, 27.12871999999993D)));
        details2.setSrcUri_("_devices/1D8D3F9F61D15345C99256530AC3440B35");
        details2.setTags_(Collections.<String>emptyList());
        details2.setChan_("9C8E635FAAB9F14EB786E7A44091D711A6");
        details2.setSrvTime_(1415190143995L);
        details2.setRemIp_("10.10.10.11");

        final List<DataPointDetails> dataPointDetails = new ArrayList<DataPointDetails>();
        dataPointDetails.add(details1);
        dataPointDetails.add(details2);

        final DataPointResultSet expectedResult = new DataPointResultSet();
        expectedResult.setTotal(2);
        expectedResult.setItemCount(2);
        expectedResult.setSkip(0);
        expectedResult.setLimit(10);
        expectedResult.setBookmark("g1AAAADPeJzLYWBgYM5gTmFQTElKzi9KdUhJMtRLzs_Ly8w3MACycvJLUxLzSvTyUktygEqZkhSAZJL9____szKY3Ow_MIBBIgOqEUZ4jXAAGREPM");
        expectedResult.setResultSet(dataPointDetails);


        pushResponse(mockResponseJson);

        final String appName = "BANK";
        final String channelName = "ATM.Temperature";

        final DataQuery dataQuery = new DataQuery("remote_ip:10.10.10.11", 0, 10, "", "-client.time");

        final DataPointResultSet result = dataClient.getData(appName, channelName, dataQuery);

        assertThat(result).isEqualTo(expectedResult);

        final Request request = popRequest();

        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getPath()).isEqualTo("/v1/_apps/" + appName + "/_data/" + channelName + "?query=remote_ip%253A10.10.10.11&skip=0&limit=10&sort=-client.time");
    }
}

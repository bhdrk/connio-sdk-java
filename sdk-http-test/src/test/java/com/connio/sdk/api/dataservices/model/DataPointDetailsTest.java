package com.connio.sdk.api.dataservices.model;

import com.connio.sdk.api.model.GeoCoordinates;
import com.connio.sdk.api.model.Location;
import com.connio.sdk.http.json.JSON;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.connio.sdk.api.systemservices.TestUtils.resource;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by bdirik on 31.10.2014.
 */
@Test(suiteName = "EntityTest", testName = "DataPointDetailsTest")
public class DataPointDetailsTest {

    @Test
    public void testSerializesToJSONForNumberValue() throws Exception {
        DataPointDetails dataPointDetails = new DataPointDetails();
        dataPointDetails.setTime(1414407520L);
        dataPointDetails.setValue(1);

        String actual = JSON.toString(dataPointDetails);
        String expected = resource("json/dataservices/model/dataPointDetails/numberValue.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSerializesToJSONForStringValue() throws Exception {
        DataPointDetails dataPointDetails = new DataPointDetails();
        dataPointDetails.setTime(1414407520L);
        dataPointDetails.setValue("MSG");

        String actual = JSON.toString(dataPointDetails);
        String expected = resource("json/dataservices/model/dataPointDetails/stringValue.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSerializesToJSONForChannel() throws Exception {
        DataPointDetails dataPointDetails = new DataPointDetails();
        dataPointDetails.setTime(1414407520L);
        dataPointDetails.setValue(1);
        dataPointDetails.set_chan("DATA");

        String actual = JSON.toString(dataPointDetails);
        String expected = resource("json/dataservices/model/dataPointDetails/channel.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSerializesToJSONForLocation() throws Exception {
        GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
        Location location = new Location("Izmir", geoCoord);

        DataPointDetails dataPointDetails = new DataPointDetails();
        dataPointDetails.setTime(1414407520L);
        dataPointDetails.setValue(1);
        dataPointDetails.set_chan("DATA");
        dataPointDetails.set_loc(location);

        String actual = JSON.toString(dataPointDetails);
        String expected = resource("json/dataservices/model/dataPointDetails/location.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSerializesToJSONForRemIpAndSrvTime() throws Exception {
        DataPointDetails dataPointDetails = new DataPointDetails();
        dataPointDetails.setTime(1414407520L);
        dataPointDetails.setValue(1);
        dataPointDetails.set_chan("DATA");
        dataPointDetails.set_remIp("127.0.0.1");
        dataPointDetails.set_srvTime(1414407521L);

        String actual = JSON.toString(dataPointDetails);
        String expected = resource("json/dataservices/model/dataPointDetails/remIpAndSrvTime.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSerializesToJSONForAllProperties() throws Exception {
        GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
        Location location = new Location("Izmir", geoCoord);

        DataPointDetails dataPointDetails = new DataPointDetails();
        dataPointDetails.setTime(1414407520L);
        dataPointDetails.setValue(1);
        dataPointDetails.set_chan("DATA");
        dataPointDetails.set_feedId("1009");
        dataPointDetails.set_loc(location);
        dataPointDetails.set_srcUri("_devices/_id/1101");
        dataPointDetails.set_tags(Arrays.asList("TAG1", "TAG2"));
        dataPointDetails.set_remIp("127.0.0.1");
        dataPointDetails.set_srvTime(1414407521L);

        String actual = JSON.toString(dataPointDetails);
        String expected = resource("json/dataservices/model/dataPointDetails/allProperties.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSerializesToJSONForLongStringValue() throws Exception {
        String value = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
        Location location = new Location("Izmir", geoCoord);

        DataPointDetails dataPointDetails = new DataPointDetails();
        dataPointDetails.setTime(1414407520L);
        dataPointDetails.setValue(value);
        dataPointDetails.set_chan("DATA");
        dataPointDetails.set_feedId("1009");
        dataPointDetails.set_loc(location);
        dataPointDetails.set_srcUri("_devices/_id/1101");
        dataPointDetails.set_tags(Arrays.asList("TAG1", "TAG2"));

        String actual = JSON.toString(dataPointDetails);
        String expected = resource("json/dataservices/model/dataPointDetails/longStringValue.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONForNumberValue() throws Exception {
        DataPointDetails expected = new DataPointDetails();
        expected.setTime(1414407520L);
        expected.setValue(1);

        DataPointDetails actual = JSON.fromString(resource("json/dataservices/model/dataPointDetails/numberValue.json"), DataPointDetails.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONStringValue() throws Exception {
        DataPointDetails expected = new DataPointDetails();
        expected.setTime(1414407520L);
        expected.setValue("MSG");

        DataPointDetails actual = JSON.fromString(resource("json/dataservices/model/dataPoint/stringValue.json"), DataPointDetails.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONForChannel() throws Exception {
        DataPointDetails expected = new DataPointDetails();
        expected.setTime(1414407520L);
        expected.setValue(1);
        expected.set_chan("DATA");
        DataPointDetails actual = JSON.fromString(resource("json/dataservices/model/dataPoint/channel.json"), DataPointDetails.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONForLocation() throws Exception {
        GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
        Location location = new Location("Izmir", geoCoord);

        DataPointDetails expected = new DataPointDetails();
        expected.setTime(1414407520L);
        expected.setValue(1);
        expected.set_chan("DATA");
        expected.set_loc(location);

        DataPointDetails actual = JSON.fromString(resource("json/dataservices/model/dataPointDetails/location.json"), DataPointDetails.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONForRemIpAndSrvTime() throws Exception {
        DataPointDetails expected = new DataPointDetails();
        expected.setTime(1414407520L);
        expected.setValue(1);
        expected.set_chan("DATA");
        expected.set_remIp("127.0.0.1");
        expected.set_srvTime(1414407521L);

        DataPointDetails actual= JSON.fromString(resource("json/dataservices/model/dataPointDetails/remIpAndSrvTime.json"), DataPointDetails.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONForAllProperties() throws Exception {
        GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
        Location location = new Location("Izmir", geoCoord);

        DataPointDetails expected = new DataPointDetails();
        expected.setTime(1414407520L);
        expected.setValue(1);
        expected.set_chan("DATA");
        expected.set_feedId("1009");
        expected.set_loc(location);
        expected.set_srcUri("_devices/_id/1101");
        expected.set_tags(Arrays.asList("TAG1", "TAG2"));
        expected.set_remIp("127.0.0.1");
        expected.set_srvTime(1414407521L);

        DataPointDetails actual = JSON.fromString(resource("json/dataservices/model/dataPointDetails/allProperties.json"), DataPointDetails.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONForLongStringValue() throws Exception {
        String value = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
        Location location = new Location("Izmir", geoCoord);

        DataPointDetails expected = new DataPointDetails();
        expected.setTime(1414407520L);
        expected.setValue(value);
        expected.set_chan("DATA");

        expected.set_feedId("1009");
        expected.set_loc(location);
        expected.set_srcUri("_devices/_id/1101");
        expected.set_tags(Arrays.asList("TAG1", "TAG2"));

        DataPointDetails actual = JSON.fromString(resource("json/dataservices/model/dataPointDetails/longStringValue.json"), DataPointDetails.class);

        assertThat(actual).isEqualTo(expected);
    }

}

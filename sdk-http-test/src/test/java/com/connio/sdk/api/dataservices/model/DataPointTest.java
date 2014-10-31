package com.connio.sdk.api.dataservices.model;

import com.connio.sdk.api.model.GeoCoordinates;
import com.connio.sdk.api.model.Location;
import com.connio.sdk.http.json.JSON;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.connio.sdk.api.systemservices.TestUtils.resource;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by bdirik on 27.10.2014.
 */
public class DataPointTest {

    @Test
    public void testSerializesToJSONForNumberValue() throws Exception {
        DataPoint dataPoint = new DataPoint(1414407520L, 1);

        String actual = JSON.toString(dataPoint);
        String expected = resource("json/dataPoint/numberValue.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSerializesToJSONForStringValue() throws Exception {
        DataPoint dataPoint = new DataPoint(1414407520L, "MSG");

        String actual = JSON.toString(dataPoint);
        String expected = resource("json/dataPoint/stringValue.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSerializesToJSONForChannel() throws Exception {
        DataPoint dataPoint = new DataPoint(1414407520L, 1, "DATA");

        String actual = JSON.toString(dataPoint);
        String expected = resource("json/dataPoint/channel.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSerializesToJSONForLocation() throws Exception {
        GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
        Location location = new Location("Izmir", geoCoord);

        DataPoint dataPoint = new DataPoint(1414407520L, 1, "DATA");
        dataPoint.set_loc(location);

        String actual = JSON.toString(dataPoint);
        String expected = resource("json/dataPoint/location.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSerializesToJSONForAllProperties() throws Exception {
        GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
        Location location = new Location("Izmir", geoCoord);

        DataPoint dataPoint = new DataPoint(1414407520L, 1, "DATA");
        dataPoint.set_feedId("1009");
        dataPoint.set_loc(location);
        dataPoint.set_srcUri("_devices/_id/1101");
        dataPoint.set_tags(Arrays.asList("TAG1", "TAG2"));

        String actual = JSON.toString(dataPoint);
        String expected = resource("json/dataPoint/allProperties.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSerializesToJSONForLongStringValue() throws Exception {
        String value = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
        Location location = new Location("Izmir", geoCoord);

        DataPoint dataPoint = new DataPoint(1414407520L, value, "DATA");
        dataPoint.set_feedId("1009");
        dataPoint.set_loc(location);
        dataPoint.set_srcUri("_devices/_id/1101");
        dataPoint.set_tags(Arrays.asList("TAG1", "TAG2"));

        String actual = JSON.toString(dataPoint);
        String expected = resource("json/dataPoint/longStringValue.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONForNumberValue() throws Exception {
        DataPoint expected = new DataPoint(1414407520L, 1);
        DataPoint actual = JSON.fromString(resource("json/dataPoint/numberValue.json"), DataPoint.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONStringValue() throws Exception {
        DataPoint expected = new DataPoint(1414407520L, "MSG");
        DataPoint actual = JSON.fromString(resource("json/dataPoint/stringValue.json"), DataPoint.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONForChannel() throws Exception {
        DataPoint expected = new DataPoint(1414407520L, 1, "DATA");
        DataPoint actual = JSON.fromString(resource("json/dataPoint/channel.json"), DataPoint.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONForLocation() throws Exception {
        GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
        Location location = new Location("Izmir", geoCoord);

        DataPoint expected = new DataPoint(1414407520L, 1, "DATA");
        expected.set_loc(location);

        DataPoint actual = JSON.fromString(resource("json/dataPoint/location.json"), DataPoint.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONForAllProperties() throws Exception {
        GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
        Location location = new Location("Izmir", geoCoord);

        DataPoint expected = new DataPoint(1414407520L, 1, "DATA");
        expected.set_feedId("1009");
        expected.set_loc(location);
        expected.set_srcUri("_devices/_id/1101");
        expected.set_tags(Arrays.asList("TAG1", "TAG2"));

        DataPoint actual = JSON.fromString(resource("json/dataPoint/allProperties.json"), DataPoint.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONForLongStringValue() throws Exception {
        String value = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
        Location location = new Location("Izmir", geoCoord);

        DataPoint expected = new DataPoint(1414407520L, value, "DATA");
        expected.set_feedId("1009");
        expected.set_loc(location);
        expected.set_srcUri("_devices/_id/1101");
        expected.set_tags(Arrays.asList("TAG1", "TAG2"));

        DataPoint actual = JSON.fromString(resource("json/dataPoint/longStringValue.json"), DataPoint.class);

        assertThat(actual).isEqualTo(expected);
    }
}

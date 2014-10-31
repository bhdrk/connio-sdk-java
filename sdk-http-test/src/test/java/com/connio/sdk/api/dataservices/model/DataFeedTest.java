package com.connio.sdk.api.dataservices.model;

import com.connio.sdk.api.model.GeoCoordinates;
import com.connio.sdk.api.model.Location;
import com.connio.sdk.http.json.JSON;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.connio.sdk.api.systemservices.TestUtils.resource;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by bdirik on 30.10.2014.
 */
public class DataFeedTest {

    @Test
    public void testSerializesToJSONForOneDataPoint() throws Exception {
        DataFeed dataFeed = new DataFeed();
        dataFeed.addDataPoint(new DataPoint(1414407520L, 1));

        String actual = JSON.toString(dataFeed);
        String expected = resource("json/dataFeed/oneDataPoint.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSerializesToJSONForAllProperties() throws Exception {
        GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
        Location location = new Location("Izmir", geoCoord);

        DataFeed dataFeed = new DataFeed();
        dataFeed.set_id("1021");
        dataFeed.set_srcUri("_devices/_id/100029");
        dataFeed.set_chan("DATA");
        dataFeed.set_loc(location);
        dataFeed.set_tags(Arrays.asList("TAG1", "TAG2"));

        dataFeed.addDataPoint(new DataPoint(1414681100L, 1));
        dataFeed.addDataPoint(new DataPoint(1414681101L, 2));

        String actual = JSON.toString(dataFeed);
        String expected = resource("json/dataFeed/allProperties.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSerializesToJSONForMultipleDataPoint() throws Exception {
        DataFeed dataFeed = new DataFeed();
        {
            DataPoint dataPoint = new DataPoint(1414681100L, 1);
            dataFeed.addDataPoint(dataPoint);
        }
        {
            DataPoint dataPoint = new DataPoint(1414681101L, Integer.MIN_VALUE);
            dataFeed.addDataPoint(dataPoint);
        }
        {
            DataPoint dataPoint = new DataPoint(1414681102L, Integer.MAX_VALUE);
            dataFeed.addDataPoint(dataPoint);
        }
        {
            DataPoint dataPoint = new DataPoint(1414681103L, "MSG");
            dataFeed.addDataPoint(dataPoint);
        }
        {
            DataPoint dataPoint = new DataPoint(1414681104L, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
            dataFeed.addDataPoint(dataPoint);
        }
        {
            DataPoint dataPoint = new DataPoint(1414681105L, 1, "DATA");
            dataFeed.addDataPoint(dataPoint);
        }
        {
            GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
            Location location = new Location("Izmir", geoCoord);

            DataPoint dataPoint = new DataPoint(1414681106L, 1, "DATA");
            dataPoint.set_loc(location);
            dataFeed.addDataPoint(dataPoint);
        }
        {
            GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
            Location location = new Location("Izmir", geoCoord);

            DataPoint dataPoint = new DataPoint(1414681107L, 1, "DATA");
            dataPoint.set_feedId("1009");
            dataPoint.set_loc(location);
            dataPoint.set_srcUri("_devices/_id/1101");
            dataPoint.set_tags(Arrays.asList("TAG1", "TAG2", "TAG3"));

            dataFeed.addDataPoint(dataPoint);
        }

        String actual = JSON.toString(dataFeed);
        String expected = resource("json/dataFeed/multipleDataPoint.json");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONForOneDataPoint() throws Exception {
        DataFeed expected = new DataFeed();
        expected.addDataPoint(new DataPoint(1414407520L, 1));

        DataFeed actual = JSON.fromString(resource("json/dataFeed/oneDataPoint.json"), DataFeed.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONForAllProperties() throws Exception {
        GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
        Location location = new Location("Izmir", geoCoord);

        DataFeed expected = new DataFeed();
        expected.set_id("1021");
        expected.set_srcUri("_devices/_id/100029");
        expected.set_chan("DATA");
        expected.set_loc(location);
        expected.set_tags(Arrays.asList("TAG1", "TAG2"));

        expected.addDataPoint(new DataPoint(1414681100L, 1));
        expected.addDataPoint(new DataPoint(1414681101L, 2));

        DataFeed actual = JSON.fromString(resource("json/dataFeed/allProperties.json"), DataFeed.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeserializesFromJSONForMultipleDataPoint() throws Exception {
        DataFeed expected = new DataFeed();
        {
            DataPoint dataPoint = new DataPoint(1414681100L, 1);
            expected.addDataPoint(dataPoint);
        }
        {
            DataPoint dataPoint = new DataPoint(1414681101L, Integer.MIN_VALUE);
            expected.addDataPoint(dataPoint);
        }
        {
            DataPoint dataPoint = new DataPoint(1414681102L, Integer.MAX_VALUE);
            expected.addDataPoint(dataPoint);
        }
        {
            DataPoint dataPoint = new DataPoint(1414681103L, "MSG");
            expected.addDataPoint(dataPoint);
        }
        {
            DataPoint dataPoint = new DataPoint(1414681104L, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
            expected.addDataPoint(dataPoint);
        }
        {
            DataPoint dataPoint = new DataPoint(1414681105L, 1, "DATA");
            expected.addDataPoint(dataPoint);
        }
        {
            GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
            Location location = new Location("Izmir", geoCoord);

            DataPoint dataPoint = new DataPoint(1414681106L, 1, "DATA");
            dataPoint.set_loc(location);
            expected.addDataPoint(dataPoint);
        }
        {
            GeoCoordinates geoCoord = new GeoCoordinates(38.41885D, 27.12871999999993D);
            Location location = new Location("Izmir", geoCoord);

            DataPoint dataPoint = new DataPoint(1414681107L, 1, "DATA");
            dataPoint.set_feedId("1009");
            dataPoint.set_loc(location);
            dataPoint.set_srcUri("_devices/_id/1101");
            dataPoint.set_tags(Arrays.asList("TAG1", "TAG2", "TAG3"));

            expected.addDataPoint(dataPoint);
        }

        DataFeed actual = JSON.fromString(resource("json/dataFeed/multipleDataPoint.json"), DataFeed.class);

        assertThat(actual).isEqualTo(expected);
    }

}
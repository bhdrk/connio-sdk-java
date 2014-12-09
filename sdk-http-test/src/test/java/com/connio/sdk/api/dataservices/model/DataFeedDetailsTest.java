package com.connio.sdk.api.dataservices.model;

import com.connio.sdk.http.json.JSON;
import org.fest.assertions.api.Assertions;
import org.testng.annotations.Test;

import static com.connio.sdk.api.TestUtils.resource;

/**
 * Created by bdirik on 31.10.2014.
 */
@Test(suiteName = "EntityTests", groups = "entity")
public class DataFeedDetailsTest {

    @Test
    public void testSerializesToJSON() throws Exception {
        {
            DataFeedDetails dataFeedDetails = new DataFeedDetails();
            dataFeedDetails.setAccepted(5);
            dataFeedDetails.setRejected(0);

            String actual = JSON.toString(dataFeedDetails);
            String expected = resource("json/dataservices/model/dataFeedDetails/accepted.json");

            Assertions.assertThat(actual).isEqualTo(expected);
        }
        {
            DataFeedDetails dataFeedDetails = new DataFeedDetails();
            dataFeedDetails.setAccepted(0);
            dataFeedDetails.setRejected(1);

            String actual = JSON.toString(dataFeedDetails);
            String expected = resource("json/dataservices/model/dataFeedDetails/rejected.json");

            Assertions.assertThat(actual).isEqualTo(expected);
        }
    }

    @Test
    public void testDeserializesFromJSON() throws Exception {
        {
            DataFeedDetails actual = new DataFeedDetails();
            actual.setAccepted(5);
            actual.setRejected(0);

            DataFeedDetails expected = JSON.fromString(resource("json/dataservices/model/dataFeedDetails/accepted.json"), DataFeedDetails.class);

            Assertions.assertThat(actual).isEqualTo(expected);
        }
        {
            DataFeedDetails actual = new DataFeedDetails();
            actual.setAccepted(0);
            actual.setRejected(1);

            DataFeedDetails expected = JSON.fromString(resource("json/dataservices/model/dataFeedDetails/rejected.json"), DataFeedDetails.class);

            Assertions.assertThat(actual).isEqualTo(expected);
        }
    }
}

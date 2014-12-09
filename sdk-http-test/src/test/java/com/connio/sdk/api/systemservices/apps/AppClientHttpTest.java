package com.connio.sdk.api.systemservices.apps;

import com.connio.sdk.api.dataservices.DataClient;
import com.connio.sdk.api.dataservices.IDataClient;
import com.connio.sdk.api.dataservices.model.DataFeed;
import com.connio.sdk.api.dataservices.model.DataFeedDetails;
import com.connio.sdk.api.dataservices.model.DataPoint;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.systemservices.apps.model.*;
import com.connio.sdk.api.systemservices.datachannels.DataChannelClient;
import com.connio.sdk.api.systemservices.datachannels.IDataChannelClient;
import com.connio.sdk.api.systemservices.datachannels.model.ChannelType;
import com.connio.sdk.api.systemservices.datachannels.model.DataChannel;
import com.connio.sdk.api.systemservices.datachannels.model.DataChannelDetails;
import com.connio.sdk.api.systemservices.datachannels.model.measurement.CustomMeasurementUnit;
import com.connio.sdk.api.systemservices.datachannels.model.measurement.MeasurementType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;

import static com.connio.sdk.api.TestUtils.randomName;
import static com.connio.sdk.api.systemservices.apps.model.AppStateType.STOPPED;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 22.09.2014
 */
@Test(suiteName = "HttpTests", groups = "http")
public class AppClientHttpTest {

    private IAppClient client;

    private IDataChannelClient dataChannelClient;

    private IDataClient dataClient;

    private App testApp;

    private DataChannelDetails testChannel;

    private TriggerDetails testTrigger;

    @BeforeClass
    public void beforeClass() throws Exception {
        client = new AppClient();
        dataChannelClient = new DataChannelClient();
        dataClient = new DataClient();

        testApp = new App();
        testApp.setName(randomName("TEST-APP"));
        testApp.setDisplayName("TEST APP");
        testApp.setDescription("TEST APP DESC");
        testApp.setVersion("v1.0");
        testApp.setAppStorageCapacity(100000L);
    }

    @Test
    public void testCreateApp() throws Exception {
        AppDetails result = client.createApp(testApp);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(testApp.getName());
        assertThat(result.getDisplayName()).isEqualTo(testApp.getDisplayName());
        assertThat(result.getDescription()).isEqualTo(testApp.getDescription());
        assertThat(result.getAppStorageCapacity()).isEqualTo(testApp.getAppStorageCapacity());
        assertThat(result.getVersion()).isEqualTo(testApp.getVersion());

        // for log, usage and trigger tests
        DataChannel channel = new DataChannel();
        channel.setChannelType(ChannelType.INPUT);
        channel.setMeasurementType(MeasurementType.CUSTOM);
        channel.setMeasurementUnit(CustomMeasurementUnit.NUMERIC.getSymbol());
        channel.setName(randomName("CHAN"));

        testChannel = dataChannelClient.createDataChannel(result.getName(), channel);

        final DataFeed dataFeed = new DataFeed();

        dataFeed.addDataPoint(new DataPoint(System.currentTimeMillis(), 1, testChannel.getName()));
        dataFeed.addDataPoint(new DataPoint(System.currentTimeMillis(), 1, "INVALID-CHAN"));

        final DataFeedDetails dataFeedDetails = dataClient.sendData(result.getName(), dataFeed);

        assertThat(dataFeedDetails).isNotNull();
        assertThat(dataFeedDetails.getAccepted()).isEqualTo(1);
        assertThat(dataFeedDetails.getRejected()).isEqualTo(1);
    }

    @Test(dependsOnMethods = "testCreateApp")
    public void testGetAppDetails() throws Exception {
        AppDetails result = client.getAppDetails(testApp.getName());

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(testApp.getName());
        assertThat(result.getDisplayName()).isEqualTo(testApp.getDisplayName());
        assertThat(result.getDescription()).isEqualTo(testApp.getDescription());
        assertThat(result.getAppStorageCapacity()).isEqualTo(testApp.getAppStorageCapacity());
        assertThat(result.getVersion()).isEqualTo(testApp.getVersion());
    }

    @Test(dependsOnMethods = "testCreateApp")
    public void testGetAllAppDetails() throws Exception {
        AppResultSet result = client.getAllAppDetails();

        assertThat(result).isNotNull();
        assertThat(result.getTotal()).isGreaterThan(0);
        assertThat(result.getItemCount()).isGreaterThan(0);
        assertThat(result.getResultSet()).isNotEmpty();
    }

    @Test(dependsOnMethods = "testCreateApp")
    public void testUpdateApp() throws Exception {
        String currentAppName = testApp.getName();
        String newName = randomName("TEST-APP");

        testApp.setName(newName);
        testApp.setDisplayName("UPDATED TEST APP");
        testApp.setDescription("UPDATED TEST APP DESC");
        testApp.setAppStorageCapacity(500000L);
        testApp.setVersion("v2.0");
        testApp.setState(STOPPED);

        AppDetails result = client.updateApp(currentAppName, testApp);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(testApp.getName());
        assertThat(result.getDisplayName()).isEqualTo(testApp.getDisplayName());
        assertThat(result.getDescription()).isEqualTo(testApp.getDescription());
        assertThat(result.getAppStorageCapacity()).isEqualTo(testApp.getAppStorageCapacity());
    }

    @Test(dependsOnMethods = "testCreateApp")
    public void testGetAppUsageDetails() throws Exception {
        final AppUsageDetails result = client.getAppUsageDetails(testApp.getName());

        assertThat(result).isNotNull();
        assertThat(result.getMonthlyApiRequests()).hasSize(12);
        assertThat(result.getStorageCapacityInDp()).isEqualTo(testApp.getAppStorageCapacity());
        assertThat(result.getTodayApiRequests()).isEqualTo(1);
        assertThat(result.getTodayDps()).isEqualTo(1);
        assertThat(result.getTotalApiRequests()).isEqualTo(1);
        assertThat(result.getTotalDps()).isEqualTo(1);
    }

    @Test(dependsOnMethods = "testCreateApp")
    public void testGetAppLogs() throws Exception {
        final AppLogList result = client.getAppLogs(testApp.getName());

        assertThat(result).isNotNull();
        assertThat(result.getLogs()).isNotEmpty();

        final AppLog appLog = result.getLogs().get(0);

        // log message that related to sending data to invalid channel
        assertThat(appLog).isNotNull();
        assertThat(appLog.getType()).isEqualToIgnoringCase("WARNING");
        assertThat(appLog.getLog()).containsIgnoringCase("INVALID-CHAN");
        assertThat(appLog.getDate()).isInSameHourAs(new Date());
    }

    @Test(dependsOnMethods = "testCreateApp")
    public void testCreateTrigger() throws Exception {
        final HashMap<String, String> params = new HashMap<String, String>();
        params.put("phone_number", "+905554442233");

        final TriggerAction action = new TriggerAction();
        action.setName("sms");
        action.setParams(params);

        final Condition condition = new Condition();
        condition.setOp("eq");
        condition.setUnit("number");
        condition.setValue(2);

        final Frequency freq = new Frequency();
        freq.setF("xtimesperhour");
        freq.setX("12");

        final Trigger trigger = new Trigger();
        trigger.setChannelSid(testChannel.getSid());
        trigger.setAction(action);
        trigger.setCondition(condition);
        trigger.setDisplayName(randomName("TRIGGER"));
        trigger.setFreq(freq);

        final TriggerDetails result = client.createTrigger(testApp.getName(), trigger);

        assertThat(result).isNotNull();
        assertThat(result.getDisplayName()).isEqualToIgnoringCase(trigger.getDisplayName());
        assertThat(result.getChannelSid()).isEqualToIgnoringCase(trigger.getChannelSid());
        assertThat(result.getAction()).isEqualTo(action);
        assertThat(result.getFreq()).isEqualTo(freq);
        assertThat(result.getCondition()).isEqualTo(condition);

        testTrigger = result;
    }

    @Test(dependsOnMethods = "testCreateTrigger")
    public void testGetTriggers() throws Exception {
        final TriggerResultSet result = client.getTriggers(testApp.getName());

        assertThat(result).isNotNull();
        assertThat(result.getTotal()).isGreaterThan(0);
        assertThat(result.getItemCount()).isGreaterThan(0);
        assertThat(result.getResultSet()).isNotEmpty();
    }

    @Test(dependsOnMethods = {"testGetTriggers"})
    public void testDeleteTrigger() throws Exception {
        final Deleted result = client.deleteTrigger(testApp.getName(), testTrigger.getSid());

        assertThat(result).isNotNull();
        assertThat(result.isDeleted()).isTrue();
    }

    @Test(dependsOnMethods = {"testUpdateApp", "testDeleteTrigger"})
    public void testDeleteApp() throws Exception {
        Deleted result = client.deleteApp(testApp.getName());

        assertThat(result).isNotNull();
        assertThat(result.isDeleted()).isTrue();
    }
}

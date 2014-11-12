package com.connio.sdk.api.dataservices;

import com.connio.sdk.api.auth.ConnioBasicCredentials;
import com.connio.sdk.api.auth.ConnioCredentials;
import com.connio.sdk.api.auth.ConnioCredentialsManager;
import com.connio.sdk.api.dataservices.model.*;
import com.connio.sdk.api.model.Deleted;
import com.connio.sdk.api.model.GeoCoordinates;
import com.connio.sdk.api.model.Location;
import com.connio.sdk.api.TestUtils;
import com.connio.sdk.api.systemservices.apps.AppClient;
import com.connio.sdk.api.systemservices.apps.IAppClient;
import com.connio.sdk.api.systemservices.apps.model.App;
import com.connio.sdk.api.systemservices.apps.model.AppDetails;
import com.connio.sdk.api.systemservices.datachannels.DataChannelClient;
import com.connio.sdk.api.systemservices.datachannels.IDataChannelClient;
import com.connio.sdk.api.systemservices.datachannels.model.ChannelType;
import com.connio.sdk.api.systemservices.datachannels.model.DataChannel;
import com.connio.sdk.api.systemservices.datachannels.model.DataChannelDetails;
import com.connio.sdk.api.systemservices.datachannels.model.measurement.LightMeasurementUnit;
import com.connio.sdk.api.systemservices.datachannels.model.measurement.MeasurementType;
import com.connio.sdk.api.systemservices.datachannels.model.measurement.RelativeHumidityMeasurementUnit;
import com.connio.sdk.api.systemservices.datachannels.model.measurement.TemperatureMeasurementUnit;
import com.connio.sdk.api.systemservices.deviceprofiles.DeviceProfileClient;
import com.connio.sdk.api.systemservices.deviceprofiles.IDeviceProfileClient;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfile;
import com.connio.sdk.api.systemservices.deviceprofiles.model.DeviceProfileDetails;
import com.connio.sdk.api.systemservices.devices.DevicesClient;
import com.connio.sdk.api.systemservices.devices.IDevicesClient;
import com.connio.sdk.api.systemservices.devices.model.CidType;
import com.connio.sdk.api.systemservices.devices.model.Device;
import com.connio.sdk.api.systemservices.devices.model.DeviceAccessKey;
import com.connio.sdk.api.systemservices.devices.model.DeviceDetails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.UUID;

import static com.connio.sdk.api.systemservices.devices.model.DeviceStatusType.CREATED;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

/**
 * TODO: javadoc
 * <p/>
 * Created by bdirik on 20.10.2014.
 */
@Test(suiteName = "HttpTests")
public class DataClientHttpTest {

    private String _testCredentialProfile = TestUtils.randomName("DEVICE");

    private IDataClient dataClient;
    private IAppClient appClient;
    private IDataChannelClient dataChannelClient;
    private IDeviceProfileClient deviceProfileClient;
    private IDevicesClient devicesClient;

    private String _bankAppName;
    private String _atmTempChanName;
    private String _atmLightChanName;
    private String _atmHumidityChanName;

    private String _atmProfileName;
    private String _atmDeviceSid;

    @BeforeClass
    public void beforeClass() throws Exception {
        dataClient = new DataClient(_testCredentialProfile);
        appClient = new AppClient();
        dataChannelClient = new DataChannelClient();
        deviceProfileClient = new DeviceProfileClient();
        devicesClient = new DevicesClient();
    }

    @Test
    public void createAppAndDataChannelTestData() throws Exception {

        App bankApp = new App();
        bankApp.setName(TestUtils.randomName("MYBANK"));
        bankApp.setAppStorageCapacity(1000000L);

        AppDetails appResult = appClient.createApp(bankApp);
        assertThat(appResult.getName()).isEqualToIgnoringCase(bankApp.getName());

        _bankAppName = appResult.getName();

        {
            DataChannel atmTempChan = new DataChannel();
            atmTempChan.setName(TestUtils.randomName("ATM.Temperature"));
            atmTempChan.setChannelType(ChannelType.INPUT);
            atmTempChan.setMeasurementType(MeasurementType.TEMPERATURE);
            atmTempChan.setMeasurementUnit(TemperatureMeasurementUnit.C.getSymbol());

            DataChannelDetails channelResult = dataChannelClient.createDataChannel(_bankAppName, atmTempChan);

            assertThat(channelResult.getName()).isEqualToIgnoringCase(atmTempChan.getName());
            _atmTempChanName = channelResult.getName();
        }
        {
            DataChannel atmHumidityChan = new DataChannel();
            atmHumidityChan.setName(TestUtils.randomName("ATM.Humidity"));
            atmHumidityChan.setChannelType(ChannelType.INPUT);
            atmHumidityChan.setMeasurementType(MeasurementType.RELATIVEHUMIDITY);
            atmHumidityChan.setMeasurementUnit(RelativeHumidityMeasurementUnit.PERCENTAGE.getSymbol());

            DataChannelDetails channelResult = dataChannelClient.createDataChannel(_bankAppName, atmHumidityChan);

            assertThat(channelResult.getName()).isEqualToIgnoringCase(atmHumidityChan.getName());
            _atmHumidityChanName = channelResult.getName();
        }
        {
            DataChannel atmLightChan = new DataChannel();
            atmLightChan.setName(TestUtils.randomName("ATM.Ligth"));
            atmLightChan.setChannelType(ChannelType.INPUT);
            atmLightChan.setMeasurementType(MeasurementType.LIGHT);
            atmLightChan.setMeasurementUnit(LightMeasurementUnit.LUMENS.getSymbol());

            DataChannelDetails channelResult = dataChannelClient.createDataChannel(_bankAppName, atmLightChan);

            assertThat(channelResult.getName()).isEqualToIgnoringCase(atmLightChan.getName());
            _atmLightChanName = channelResult.getName();
        }
    }

    @Test
    public void createDeviceAndProfileTestData() throws Exception {
        {
            DeviceProfile atmDeviceProfile = new DeviceProfile();
            atmDeviceProfile.setName(TestUtils.randomName("ATM"));
            atmDeviceProfile.setClazz(TestUtils.randomName("BANK"));
            atmDeviceProfile.setSubclass(TestUtils.randomName("ATM"));
            atmDeviceProfile.setVendor(TestUtils.randomName("NFC"));
            atmDeviceProfile.setProduct(TestUtils.randomName("XATM"));

            DeviceProfileDetails atmDeviceProfileDetails = deviceProfileClient.createDeviceProfile(atmDeviceProfile);

            assertThat(atmDeviceProfileDetails.getName()).isEqualToIgnoringCase(atmDeviceProfile.getName());
            _atmProfileName = atmDeviceProfileDetails.getName();
        }
        {
            Device atmDevice = new Device();
            atmDevice.setProfileName(_atmProfileName);
            atmDevice.setTags(Arrays.asList("TAG1", "TAG2"));
            atmDevice.setNotes("ATM-Istanbul");
            atmDevice.setLoc(new Location("Istanbul", new GeoCoordinates(41.00527D, 28.976959999999963D)));
            atmDevice.addCid(CidType._ID, UUID.randomUUID().toString());
            atmDevice.setStatus(CREATED);

            DeviceDetails atmDeviceDetails = devicesClient.createDevice(atmDevice);

            assertThat(atmDeviceDetails.getProfileName()).isEqualToIgnoringCase(atmDevice.getProfileName());
            _atmDeviceSid = atmDeviceDetails.getSid();

            DeviceAccessKey accessKey = devicesClient.getAccessKey(_atmDeviceSid);
            ConnioCredentials credentials = new ConnioBasicCredentials(_testCredentialProfile, accessKey.getSid(), accessKey.getAuthToken());
            ConnioCredentialsManager.addCredentials(credentials);
        }
    }

    @Test(priority = 1, dependsOnMethods = {"createAppAndDataChannelTestData", "createDeviceAndProfileTestData"})
    public void testSendDataToMultipleChannel() throws Exception {
        DataFeed dataFeed = new DataFeed();
        dataFeed.addDataPoint(new DataPoint(System.currentTimeMillis(), 25, _atmTempChanName));
        dataFeed.addDataPoint(new DataPoint(System.currentTimeMillis(), 47, _atmHumidityChanName));
        dataFeed.addDataPoint(new DataPoint(System.currentTimeMillis(), 950, _atmLightChanName));

        DataFeedDetails dataFeedDetails = dataClient.sendData(_bankAppName, dataFeed);

        assertThat(dataFeedDetails).isNotNull();
        assertThat(dataFeedDetails.getAccepted()).isEqualTo(3);
        assertThat(dataFeedDetails.getRejected()).isEqualTo(0);
    }

    @Test( dependsOnMethods = {"createAppAndDataChannelTestData", "createDeviceAndProfileTestData"})
    public void testSendDataToSingleChannel() throws Exception {
        String feed1 = UUID.randomUUID().toString();
        String feed2 = UUID.randomUUID().toString();

        DataPoint dataPoint1 = new DataPoint(System.currentTimeMillis(), 26, _atmTempChanName);
        dataPoint1.setFeedId_(feed1);

        DataPoint dataPoint2 = new DataPoint(System.currentTimeMillis(), 27, _atmHumidityChanName);
        dataPoint2.setFeedId_(feed2);

        DataFeedDetails dataFeedDetails = dataClient.sendData(_bankAppName, _atmTempChanName, new DataFeed(dataPoint1, dataPoint2));

        assertThat(dataFeedDetails).isNotNull();
        assertThat(dataFeedDetails.getAccepted()).isEqualTo(2);
        assertThat(dataFeedDetails.getRejected()).isEqualTo(0);

        DataQuery dataQuery = new DataQuery();
        dataQuery.setSort("-client.time");
        dataQuery.setLimit(2);

        {
            DataPointResultSet result = dataClient.getData(_bankAppName, _atmTempChanName, dataQuery);
            assertThat(extractProperty("feedId_").from(result.getResultSet())).contains(feed1, feed2);
        }
        {
            DataPointResultSet result = dataClient.getData(_bankAppName, _atmHumidityChanName, dataQuery);
            assertThat(extractProperty("feedId_").from(result.getResultSet())).doesNotContain(feed1, feed2);
        }
    }

    @Test( dependsOnMethods = {"createAppAndDataChannelTestData", "createDeviceAndProfileTestData"})
    public void testSendDataWithFeedId() throws Exception {
        String feedId = UUID.randomUUID().toString();

        Location location = new Location("Izmir", new GeoCoordinates(38.41885D, 27.12871999999993D));

        DataPoint dataPoint = new DataPoint(System.currentTimeMillis(), 900);
        dataPoint.setFeedId_(feedId);
        dataPoint.setLoc_(location);

        DataFeedDetails dataFeedDetails = dataClient.sendData(_bankAppName, _atmLightChanName, new DataFeed(dataPoint));

        assertThat(dataFeedDetails).isNotNull();
        assertThat(dataFeedDetails.getAccepted()).isEqualTo(1);
        assertThat(dataFeedDetails.getRejected()).isEqualTo(0);

        DataQuery dataQuery = new DataQuery();
        dataQuery.setSort("-client.time");
        dataQuery.setLimit(1);

        DataPointResultSet result = dataClient.getData(_bankAppName, _atmLightChanName, dataQuery);

        assertThat(result).isNotNull();
        assertThat(result.getItemCount()).isEqualTo(1);
        assertThat(result.getResultSet()).hasSize(1);

        DataPointDetails dataPointDetails = result.getResultSet().get(0);

        assertThat(dataPointDetails.getFeedId_()).isEqualToIgnoringCase(feedId);
        assertThat(dataPointDetails.getLoc_()).isEqualTo(location);
    }

    @Test(dependsOnMethods = "testSendDataToMultipleChannel")
    public void testGetData() throws Exception {
        {
            DataQuery dataQuery = new DataQuery();
            DataPointResultSet result = dataClient.getData(_bankAppName, _atmTempChanName, dataQuery);

            assertThat(result).isNotNull();
            assertThat(result.getTotal()).isGreaterThan(0);
            assertThat(result.getItemCount()).isGreaterThan(0);
            assertThat(result.getResultSet()).isNotEmpty();
        }
        {
            DataQuery dataQuery = new DataQuery();
            DataPointResultSet result = dataClient.getData(_bankAppName, _atmHumidityChanName, dataQuery);

            assertThat(result).isNotNull();
            assertThat(result.getTotal()).isGreaterThan(0);
            assertThat(result.getItemCount()).isGreaterThan(0);
            assertThat(result.getResultSet()).isNotEmpty();
        }
        {
            DataQuery dataQuery = new DataQuery();
            DataPointResultSet result = dataClient.getData(_bankAppName, _atmLightChanName, dataQuery);

            assertThat(result).isNotNull();
            assertThat(result.getTotal()).isGreaterThan(0);
            assertThat(result.getItemCount()).isGreaterThan(0);
            assertThat(result.getResultSet()).isNotEmpty();
        }
    }

    @Test(dependsOnMethods = {"testGetData", "testSendDataToMultipleChannel", "testSendDataToSingleChannel", "testSendDataWithFeedId"})
    public void deleteTestData() throws Exception {
        {
            Deleted result = appClient.deleteApp(_bankAppName);
            assertThat(result.isDeleted()).isTrue();
        }
        {
            Deleted result = devicesClient.deleteDevice(_atmDeviceSid);
            assertThat(result.isDeleted()).isTrue();
        }
        {
            Deleted result = deviceProfileClient.deleteDeviceProfile(_atmProfileName);
            assertThat(result.isDeleted()).isTrue();
        }
    }
}

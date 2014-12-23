#Connio Sdk Java

Java SDK provides an easy way to access data services and system services of Connio Platform.

## Usage

**1)** We are using Apache Maven for building and dependency management. SDK does not exists on any Maven Repo yet. So you should check out source code from github and build it. use:

```
mvn clean install
```

After build you should add `sdk-core-api.jar` and `sdk-http.jar` packages. Also if just want to send data from a device add `sdk-api-dataservices.jar`. for system management add `sdk-api-systemservices.jar`.


**2)** SDK just needs Connio credentials. Create a file named as `.connauth` in user home directory and put specified lines below.

```
connio.auth.default.accessKey=<YOUR ACCESS KEY>
connio.auth.default.secretKey=<YOUR SECRET KEY>
```

If you have multiple accounts then can add them with different credential profile names.

```
# DEFAULT PROFILE CREDENTIALS
connio.auth.default.accessKey=<YOUR ACCESS KEY>
connio.auth.default.secretKey=<YOUR SECRET KEY>

# MY PROFILE 1 CREDENTIALS
connio.auth.myProfile1.accessKey=<PROFILE 1 ACCESS KEY>
connio.auth.myProfile1.secretKey=<PROFILE 1 SECRET KEY>

# MY PROFILE 2 CREDENTIALS
connio.auth.myProfile2.accessKey=<PROFILE 2 ACCESS KEY>
connio.auth.myProfile2.secretKey=<PROFILE 2 SECRET KEY>

```

An alternative way you can add credentials programmatically.

```java
ConnioCredentials credentials = new ConnioBasicCredentials(ConnioCredentials.DEFAULT_PROFILE, "<YOUR ACCESS KEY>", "<YOUR SECRET KEY>");
ConnioCredentialsManager.addCredentials(credentials);

ConnioCredentials credentials1 = new ConnioBasicCredentials("MyProfile1", "<PROFILE 1 ACCESS KEY>", "<PROFILE 1 SECRET KEY>");
ConnioCredentialsManager.addCredentials(credentials1);

ConnioCredentials credentials2 = new ConnioBasicCredentials("MyProfile2", "<PROFILE 2 ACCESS KEY>", "<PROFILE 2 SECRET KEY>");
ConnioCredentialsManager.addCredentials(credentials2);
```

**3)** Now ready to go. Just call any service method.

```java
 AccountClient client = new AccountClient();
 AccountDetails result = client.getMyAccountDetails();
 System.out.println(result.getDisplayName());
```

This client will be created with default credential profile. You can specify another profile name as client constructor parameter.

```java
AccountClient client = new AccountClient("MyProfile1");
```

Happy Coding



# Extras

## Custom Configuration

SDK have some configuration parameters that listed below.

```
connio.http.serviceUrl=http://api.connio.com

connio.http.connectionTimeout=50000
connio.http.connectionRequestTimeout=30000

connio.http.proxyHost=
connio.http.proxyPort=
connio.http.proxyProtocol=
connio.http.proxyUsername=
connio.http.proxyPassword=
connio.http.proxyDomain=
connio.http.proxyWorkstation=
```

You can override these parameters various way.

* from custom properties file.
* from jvm system properties.
* from environment variables.

**Custom properties file**

Create a properties file named as `connio.properties` in user home directory or in same directory of jar package of your application.

**Jvm system properties**

Use `-Dconnio.http.serviceUrl=<New Value>` from command line or `System.setProperty("connio.http.serviceUrl","<New Value>")` programmatically.

**Environment variables**

Use underscore (_) char instead of dot (.) char. `CONNIO_HTTP_SERVICEURL=<New Value>`


## Custom Transformer

SDK divided two part like API and Transformers and these parts isolated from each other. By default implemented for http transformer. It is possible to create new transformers like mqtt, socket and so on. Or possible to create your custom transformer.

**1)** Remove sdk-http.jar package from your project

**2)** Create a new tranformer that extends `com.connio.sdk.api.core.AbstractClientTransformer`

**3)** Create a new flie named as com.connio.sdk.api.core.ConnioClientTransformer in src/main/resources/META-INF/services and put your custom transformer class full name here. E.g. com.mycompany.MyCustomTransformer

That's all. SDK automatically detects your transformer and will use it.

## TODOS

1. Add SSL support.
1. Add asyncron communication support.
1. Add javadocs :)

#### How to build this package

##### Prerequisites

* ensure you have `maven3` installed and `Java8`
  * verify it by `mvn -version`  
  
##### Verified, what next ?

* build package by `mvn clean install`
  * built packages are located in `target` directory:
    * `mailinator-client-${version}.jar`
      * slim jar without dependencies
    * `mailinator-client-${version}-uber.jar`
      * uber jar with all necessary dependencies
    * `mailinator-client-${version}-sources.jar`
    * `mailinator-client-${version}-javadoc.jar`
  
#### How to use it

##### in non-maven (non-dependencies-management tool) projects

Use `mailinator-client-${version}-uber.jar` and add it to the classpath

##### in maven projects

Add dependency:

```xml
    <dependencies>
        <dependency>
            <groupId>com.manybrain</groupId>
            <artifactId>mailinator-client</artifactId>
            <version>${version}</version>
        </dependency>
    </dependencies>
```

#### Usage example

##### Create MailinatorClient

```java
MailinatorClient mailinatorClient = new MailinatorClient("yourApiKeyHere");
```

###### Get all messages from domain

```java
Inbox inbox = mailinatorClient.request(new GetInboxRequest("yourDomainNameHere"));
```

###### Get paginated messages from domain and inbox

```java
Inbox inbox = mailinatorClient.request(GetInboxRequest.builder()
                                                       .domain("yourDomainNameHere")
                                                       .limit(1)
                                                       .skip(0)
                                                       .sort(Sort.ASC)
                                                       .build());
```
                                                       
###### Get message
             
```java                                
Message message = mailinatorClient.request(new GetMessageRequest(
                                                                "yourDomainNameHere", 
                                                                "test", 
                                                                "test-1574418771-2639"));
```





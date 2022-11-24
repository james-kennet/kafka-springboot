## Sample kafka-project

### Prerequisite on running this project:
- Install Java 11(Needed by Kafkdrop - kafka message viewer).
- Install Docker Desktop.
- JMeter - for testing.

### Tech stack and services in kafka-project.
- kafka
- zookeeper
- Kafkdrop - kafka message viewer
- kafka-consumer service
- kafka-producer service
- address-service - services to process consume messages
- MySql - to save all transactions

### Use Cases(Address creation)
* In the insurance domain, given with multiple platforms like:
    * Website applications
    * Salesforce
    * Life400 - mainframe
* Use kafka to received all the ADDRESS creation from multiple platforms and process to the downstream services.

### Use Case #1
* Kafka as traditional message broker.
  * One topic per platform
    * ADDRESS_CREATE_SALESFORCE
    * ADDRESS_CREATE_WEBSITE
    * ADDRESS_CREATE_LIFE400
  * One producer endpoint per platform/topic.
  * One consumer listener per platform/topic.
* Sample architecture diagram
    ![My Image](./_external_files/kafka-demo-Sample1-NormalQueue.jpg)

### Use Case #2
* Kafka single topic with consumer using recordFilterStrategy.
  * One topic to all platform with different clientType.
    * ADDRESS_CREATE_ALL_PLATFORM
  * One producer endpoint to all platform.
  * One consumer listener per platform clientType by using recordFilterStrategy.
    * containerFactory = "allPlatformSalesforceFactory"
    * containerFactory = "allPlatformWebsiteFactory"
    * containerFactory = "allPlatformLife400Factory"
* Sample architecture diagram
* ![My Image](./_external_files/kafka-demo-Sample2-Filter.jpg)

### Steps in running kafka-project locally.
- Checkout the project in Github.
- Go the project directory.
```bash
cd /<path>/kafka-springboot/kafka-project
```
- Install kafka-project services.
```bash
mvn clean install
```
- Start kafka-project services.
```bash
docker-compose up
```
- View Kafdrop on the browser using the below URL.
```bash
http://localhost:9000
```

### Testing kafka-project locally.
- Execute the below jmeter scripts.
```bash
path - /<path>/kafka-springboot/kafka-project/_external_files/kafka-producer-v1.jmx
```
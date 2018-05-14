# Microservices
Spring Boot Micorservices with Eureka discovery client.
The Producer uses Spring Data and JpaRepository to access data from a local sql file.
The Consumer uses RestTemplate to consume the rest api that the producer exibits after discovering it using the Eureka naming servier.

# Quickstart
The project is divedet in 3 folders:
1. Eureka Discovery Service
2. Currency Exchange Rate MicroService (Producer)
3. Conversion Service (Consumer)

We can run our application Eureka Server, Producer and Consumer.


Create the application target using maven to create an executable jar that is in the target folder.
```
$ mvn clean install
$ java -jar target/eureka-service.0.0.1-SNAPSHOT.jar
# Run the server
```

In a second terminal tab

```
$ mvn clean install
$ java -Dserver.port=8098 -jar target/spring-boot-microservice-currency-service.0.0.1-SNAPSHOT.jar
# Run the producer
```

In a third terminal tab

```
$ mvn clean install
$ java -Dserver.port=8099 -jar target/conversion-service.0.0.1-SNAPSHOT.jar
# Run the consumer
```

You can then call the method the the consumer exibits
```
http://localhost:8099/conversion-exchange/100/from/EUR/to/USD
```

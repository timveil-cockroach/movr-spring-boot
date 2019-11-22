# MOVR Sample Application - Spring Boot
This is an example, full stack, application using the following technologies:
* Spring Boot
* JPA for persistence
* Thymeleaf for UI templating
* Bootstrap for UI rendering

> :warning: This project is in active development and likely not stable.  Proceed at your own risk. :warning:

## How to Build
```
./mvnw clean package
```

## How to Run

### CockroachDB on Docker

1) Start a single node CockroachDB instance
```bash
docker run -d --name=crdb --hostname=crdb -p 26257:26257 -p 8080:8080 cockroachdb/cockroach:latest start-single-node --insecure
```

4) Start an instance of the `movr-spring-boot` application locally using Maven
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

5) Open the MOVR UI: http://localhost:8082/

6) Open the CockroachDB UI: http://localhost:8080/

7) Shut down the `crdb` Docker image when ready
```bash
docker stop crdb && docker rm crdb
```

### CockroachDB on Kubernetes
todo
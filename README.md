# MOVR Sample Application - Spring Boot
This is an example, full stack, application using the following technologies:
* Spring Boot
* JPA for persistence
* Thymeleaf for UI templating
* Bootstrap for UI rendering

## How to Build
```
./mvnw clean package
```

## How to Run

### Docker

1) Start a single node CockroachDB instance
    ```bash
    docker run -d --name=crdb --hostname=crdb -p 26257:26257 -p 8080:8080 cockroachdb/cockroach:latest start-single-node --insecure
    ```
2) Create the `movr` database using CockroachDB's `workload` service
    ```bash
    docker exec -it crdb ./cockroach workload init movr 'postgresql://root@crdb:26257?sslmode=disable'
    ```
3) Run the `movr` workload generator to create data and simulate load
    ```bash
    docker exec -it crdb ./cockroach workload run movr --duration=5m 'postgresql://root@crdb:26257?sslmode=disable'
    ```
4) Start an instance of the `movr-spring-boot` application using Maven
    ```bash
    ./mvnw spring-boot:run -Dspring-boot.run.profiles=local
    ```
5) Open the MOVR UI: http://localhost:8082/

6) Open the CockroachDB UI:  http://localhost:8080/

7) Shut down the `crdb` Docker image when ready
```bash
docker stop crdb && docker rm crdb
```

### Kubernetes
todo
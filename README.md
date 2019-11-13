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

## Miscellaneous notes to self

init bank
docker exec -it crdb ./cockroach workload init bank 'postgresql://root@crdb:26257?sslmode=disable'

run bank
docker exec -it crdb ./cockroach workload run bank --duration=5m 'postgresql://root@crdb:26257?sslmode=disable'





kubectl run bootdemo --image=timveil/crdb-springboot-demo:0.0.3-SNAPSHOT --image-pull-policy=Always --port=8082

kubectl expose deployment bootdemo --type=LoadBalancer --port=8082

minikube service bootdemo



kubectl get services

minikube ip



kubectl delete pod <pod name>

kubectl delete deployment bootdemo

kubectl delete service bootdemo


settings.xml
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                  https://maven.apache.org/xsd/settings-1.0.0.xsd">
    <servers>
        <server>
            <id>docker.io</id>
            <username>[...]</username>
            <password>[...]</password>
        </server>
    </servers>
</settings>
```
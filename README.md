## Start a Single Node CRDB Instance for Testing

start cluster
docker run -d --name=crdb --hostname=crdb -p 26257:26257 -p 8080:8080  cockroachdb/cockroach:latest start-single-node --insecure

init movr
docker exec -it crdb ./cockroach workload init movr 'postgresql://root@crdb:26257?sslmode=disable'

run movr
docker exec -it crdb ./cockroach workload run movr --duration=5m 'postgresql://root@crdb:26257?sslmode=disable'

run application
./mvnw spring-boot:run -Dspring-boot.run.profiles=local

docker stop crdb && docker rm crdb

-------------------------

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
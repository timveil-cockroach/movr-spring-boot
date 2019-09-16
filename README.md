kubectl run bootdemo --image=timveil/crdb-springboot-demo:0.0.1-SNAPSHOT --port=8082

minikube ip

kubectl expose deployment/bootdemo --type="NodePort" --port 8082

kubectl delete deployment/bootdemo

kubectl delete service/bootdemo


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
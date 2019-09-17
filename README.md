kubectl run bootdemo --image=timveil/crdb-springboot-demo:0.0.3-SNAPSHOT --image-pull-policy=Always --port=8082

minikube ip

kubectl expose deployment bootdemo --type=LoadBalancer --port=8082

kubectl get services

minikube service bootdemo

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
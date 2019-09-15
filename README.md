kubectl run bootdemo --image=timveil/crdb-springboot-demo:0.0.1-SNAPSHOT --port=8082

minikube ip

kubectl expose deployment/bootdemo --type="NodePort" --port 8082

kubectl delete deployment/bootdemo

kubectl delete service/bootdemo
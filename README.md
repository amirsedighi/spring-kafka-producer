spring-k8s is a very simple Spring Boot microesrvice to deploy on K8s.

Here are the steps:
To run the app on your local machine:
$> mvn sprint-boot:run
OR
Run it inside IDE

Check the endpoint:
$> curl localhost:8080/hello
Hello!


To try it using minikube:
- Start Docker Desktop
- $> mvn clean install
  $> minikube -p minikube docker-env          # Optional
- $> eval $(minikube -p minikube docker-env)  # Optional
- $> minikube start
- $> minikube dashboard
- $> k cluster-info                           # Optional
- $> eval $(minikube docker-env)  # right before buiding the image
- $> docker build -t spring-kafka-producer-img .
- $> k apply -f ./manifest
- $> k get services -n micro-process
- $> minikube service spring-kafka-producer-service -n micro-process
- $> curl curl http://SERVICE:PORT/app/hello


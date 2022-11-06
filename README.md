# Docker

mvn clean package
docker build -t docker-demo .
docker run -p 8080:8080 docker-demo

# Registry
docker login
docker tag docker-demo <user-id>/docker-demo
docker push <user-id>/docker-demo
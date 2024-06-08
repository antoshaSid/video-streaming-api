FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/api-gateway-service.jar api-gateway-service.jar
ENTRYPOINT ["java", "-jar", "/api-gateway-service.jar"]
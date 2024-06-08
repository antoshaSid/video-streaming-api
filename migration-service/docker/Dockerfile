FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/migration-service.jar migration-service.jar
ENTRYPOINT ["java", "-jar", "/migration-service.jar"]
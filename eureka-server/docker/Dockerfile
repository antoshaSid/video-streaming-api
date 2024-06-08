FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/eureka-server.jar eureka-server.jar
ENTRYPOINT ["java", "-jar", "/eureka-server.jar"]
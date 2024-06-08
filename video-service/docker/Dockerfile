FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/video-service.jar video-service.jar
ENTRYPOINT ["java", "-jar", "/video-service.jar"]

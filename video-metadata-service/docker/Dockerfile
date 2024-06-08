FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/video-metadata-service.jar video-metadata-service.jar
ENTRYPOINT ["java", "-jar", "/video-metadata-service.jar"]

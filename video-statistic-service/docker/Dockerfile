FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/video-statistic-service.jar video-statistic-service.jar
ENTRYPOINT ["java", "-jar", "/video-statistic-service.jar"]

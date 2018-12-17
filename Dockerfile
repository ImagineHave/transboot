FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD transboot-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar","/app.jar"]
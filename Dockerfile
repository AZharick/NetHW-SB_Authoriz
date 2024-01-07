#openjdk:17-jdk-slim + JDK20 fails
#openjdk:11 + JDK20 fails
#openjdk:11 + JDK17 fails
#openjdk:17-jdk-slim + JDK17 works (pom java 17 also)
FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY target/SB_REST-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
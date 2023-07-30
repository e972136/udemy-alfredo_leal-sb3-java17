FROM openjdk:17-jdk-slim as build

COPY target/reservation-0.0.1.jar reservation-0.0.1.jar

ENTRYPOINT ["java","-jar","/reservation-0.0.1.jar"]
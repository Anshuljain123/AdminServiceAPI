FROM openjdk:8-jdk-alpine

MAINTAINER="anshul.jain@idexcel.net"

EXPOSE 8080

COPY ./target/anshul-admin-service-0.0.1-SNAPSHOT.jar anshul-admin-service-0.0.1-SNAPSHOT.jar


ENTRYPOINT ["java","-jar","anshul-admin-service-0.0.1-SNAPSHOT.jar"]
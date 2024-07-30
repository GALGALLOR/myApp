# Base image
FROM registry.access.redhat.com/ubi8/openjdk-22:latest
# ownership
LABEL maintainer="KCB Group Technology - BSS" version="v1.0.0"
# env variables
ENV TZ=Africa/Nairobi
# App port
EXPOSE 8080
# change user
USER root
# upgrade packages
RUN microdnf install curl ca-certificates \
    && microdnf update \
    && microdnf upgrade -y
# Copy jar
COPY target/*.jar /opt/app.jar
WORKDIR /opt
# change user
USER root
# upgrade packages
RUN microdnf install curl ca-certificates \
    && microdnf update \
    && microdnf upgrade -y
# revert user
USER jboss
# CMD
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
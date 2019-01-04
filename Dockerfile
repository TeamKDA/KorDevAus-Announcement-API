FROM openjdk:8-jre-alpine

MAINTAINER Alex Park

ENV \
  CAMUNDA_BPM_VERSION=7.9.0 \
  DESC="KDA Camel App based on SpringBoot"

VOLUME /tmp
ARG JAR_FILE 
COPY ${JAR_FILE} app.jar
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
FROM openjdk:8-jdk-alpine
MAINTAINER Humberto Pinheiro <humbhenri@gmail.com>
VOLUME /tmp
ADD target/matricula-0.0.1-SNAPSHOT.jar /app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Xmx100M", "-jar","/app.jar", "--server.port=8080"]
EXPOSE 8080
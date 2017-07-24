FROM java:8
MAINTAINER Humberto Pinheiro <humbhenri@gmail.com>
VOLUME /tmp
ADD target/matricula-0.0.1-SNAPSHOT.jar /app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080

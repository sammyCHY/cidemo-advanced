FROM bellsoft/liberica-openjdk-alpine:17.0.6
RUN mkdir /app
COPY target/cidemo-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java", "-jar", "/app/cidemo-0.0.1-SNAPSHOT.jar"]
EXPOSE 8888

# Continuous Integration Demo
This repository is a simple Spring Boot App to demonstrate the process of Continuous Integration using GitHub, Maven, Jenkins, Docker, and Docker Hub. The CI process checks out the code from GitHub, package it, build the image, and push the image to DockerHub, fully automated.

## Prerequisites
- Basic understanding of Git, GitHub, Docker, DockerHub, and CI/CD
- Right versions of Java and Maven installed on your machine (check [Dependencies](#Dependencies) below)
- Git, Jenkins, and Docker installed on your machine
- GitHub account with Personal Access Token configured
- DockerHub account with `cidemo` repository created

## Getting Started
- Clone this repository to your local machine.

## How to run
### As JAR using Maven
- Run `mvn clean package` from the project root to build jar.
- Run `java -jar target/cidemo-0.0.1-SNAPSHOT.jar` or `mvn spring-boot:run` to run the application.
- Open any browser on your machine and visit `http://localhost:8888`. You should see the WhiteLabel page. You may also visit `http://localhost:8888/v1/ping`.

### As Container using Docker
- Run `mvn clean package` from the project root to build jar.
- Run `docker build -t [docker-username]/cidemo:[version] .` to build image. Replace '[docker-username]' with your Docker Hub account username and '[version]' with any string or number of your choice.
- Run `docker run -p [host-port]:8888 [docker-username]/cidemo:[version]`. Replace '[host-port]' with a four-digit number representing an available port number on your machine where the application will run.
- Open any browser on your machine and visit `http://localhost:[host-port]`. You should see the WhiteLabel page. You may also visit `http://localhost:[host-port]/v1/ping`. Replace '[host-port]' with your choice in the previous step.

## Dependencies
* Java 21
* Spring Boot 3.4.2
* JUnit 4.13.2
* Apache Maven 3.8.7

## License
This repository is free to use.

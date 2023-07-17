#########################
# the building image
#########################
FROM maven:3.8.1-openjdk-17-slim as build

WORKDIR /workspace/app

COPY pom.xml .
COPY src src

RUN mvn clean dependency:resolve verify package

#########################
# the running image
#########################
FROM openjdk:17-jdk-alpine3.14

WORKDIR /workspace/app

VOLUME /tmp
COPY --from=build /workspace/app/target/sparkexample-jar-with-dependencies.jar app.jar

EXPOSE 4567
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]

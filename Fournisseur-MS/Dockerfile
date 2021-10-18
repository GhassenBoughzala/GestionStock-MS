FROM adoptopenjdk/openjdk11:latest
EXPOSE 8080
ADD /target/candidates-service-twin4-0.0.1-SNAPSHOT.jar candidates-service-twin4-0.0.1-SNAPSHOT.jar
ENTRYPOINT { "java", "jar", "candidates-service-twin4-0.0.1-SNAPSHOT.jar" }
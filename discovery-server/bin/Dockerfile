FROM adoptopenjdk/openjdk11:latest
EXPOSE 8080
ADD /target/discovery-service-5twin4-0.0.1-SNAPSHOT.jar discovery-service-5twin4-0.0.1-SNAPSHOT.jar
ENTRYPOINT { "java", "jar", "discovery-service-5twin4-0.0.1-SNAPSHOT.jar" }
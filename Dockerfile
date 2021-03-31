FROM openjdk:8u121-jre-alpine
ADD target/tecnico-0.0.1-SNAPSHOT.jar tecnico-0.0.1-SNAPSHOT.jar
EXPOSE 8050
ENTRYPOINT ["java", "-jar", "tecnico-0.0.1-SNAPSHOT.jar"]
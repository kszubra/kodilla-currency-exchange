FROM adoptopenjdk:11-jre-hotspot as builder
COPY ./target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8069

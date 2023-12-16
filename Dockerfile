FROM openjdk:21-jdk-slim
ADD target/practic2web-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
FROM openjdk:8
ADD target/api-cotacao-dollar.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
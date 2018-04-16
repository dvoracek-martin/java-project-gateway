FROM openjdk
ADD target/gateway.jar gateway.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 9000
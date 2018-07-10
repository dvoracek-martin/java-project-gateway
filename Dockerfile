FROM openjdk
ADD target/java-project-gateway-web.jar java-project-gateway-web.jar
ENTRYPOINT ["java", "-jar", "/java-project-gateway-web.jar"]
EXPOSE 80
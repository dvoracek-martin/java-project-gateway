FROM openjdk
ADD target/java-project-time-provider-web.jar java-project-time-provider-web.jar
ENTRYPOINT ["java", "-jar", "/java-project-time-provider-web.jar"]
EXPOSE 80
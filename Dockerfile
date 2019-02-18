FROM openjdk:latest
COPY ./target/populatio-0.2.0-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "populatio-0.2.0-jar-with-dependencies.jar"]
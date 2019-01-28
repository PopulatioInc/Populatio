FROM openjdk:latest
COPY ./target/populatio-0.1.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "populatio-0.1-jar-with-dependencies.jar"]
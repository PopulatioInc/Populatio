FROM openjdk:latest
COPY ./target/ppopulatio.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "populatio.jar", "db:3306"]
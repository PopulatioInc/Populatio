FROM openjdk:latest
COPY ./target/populatio.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "populatio.jar", "db:3306"]
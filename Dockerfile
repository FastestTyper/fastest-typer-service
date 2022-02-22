FROM maven as builder
COPY . .
RUN mvn package spring-boot:repackage

FROM openjdk:11.0.8-slim-buster
COPY --from="builder" /target/fastest-typer-service-0.0.1-SNAPSHOT.jar .
CMD java -jar -Dspring.profiles.active=${profile} fastest-typer-service-0.0.1-SNAPSHOT.jar --dbHost=${dbHost} --dbHost=${dbPort} --dbUser=${dbUser} --dbPassword=${dbPassword} --dbInitializationMode=${dbInitializationMode} --dbDdlAuto=${dbDdlAuto}

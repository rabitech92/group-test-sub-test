#FROM openjdk:17
#
#COPY target/spring-boot-docker-app.jar  /usr/java/
#
#WORKDIR /usr/app/
#
#EXPOSE 8080
#
#ENTRYPOINT ["java", "-jar", "spring-java.jar"]

FROM openjdk:17
COPY target/mysqldb-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]
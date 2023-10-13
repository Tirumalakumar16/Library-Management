FROM eclipse-temurin:18-alpine
VOLUME /tmp
EXPOSE 8888
ARG JAR_FILE=target/library-management.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
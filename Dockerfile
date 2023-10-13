FROM eclipse-temurin:18-alpine
VOLUME /tmp
EXPOSE 8888
ARG JAR_FILE=target/library-management.jar
ADD ${JAR_FILE} library-management.jar
ENTRYPOINT ["java","-jar","/library-management.jar"]
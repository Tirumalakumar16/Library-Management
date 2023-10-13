FROM eclipse-temurin:18-alpine
EXPOSE 8888
ADD target/library-management.jar library-management.jar
ENTRYPOINT["java","-jar","/library-management.jar"]
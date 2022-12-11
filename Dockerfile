FROM openjdk:19
ADD target/StorageApplication.jar StorageApplication.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/StorageApplication.jar"]
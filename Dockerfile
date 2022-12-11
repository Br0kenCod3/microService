FROM openjdk:19
ADD target/storage.jar storage.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/storage.jar"]
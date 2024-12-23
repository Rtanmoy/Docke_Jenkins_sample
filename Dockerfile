FROM openjdk:17
EXPOSE 8081
ADD target/docker_image_sample.jar docker_image_sample.jar
ENTRYPOINT ["java","-jar","/docker_image_sample.jar"]
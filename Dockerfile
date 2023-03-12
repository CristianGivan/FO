# docker image
FROM openjdk:17
ADD target/fo-app.jar fo-app.jar
ENTRYPOINT ["java","-jar","fo-app.jar"]
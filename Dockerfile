FROM openjdk:14-jdk-alpine
ARG JAR_FILE=reservation_boot/target/*.jar
COPY ${JAR_FILE} fba.jar
ENTRYPOINT ["java","-jar","/fba.jar"]
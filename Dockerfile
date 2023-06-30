# Use a lightweight base image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file built with Eclipse into the container
COPY target/*.jar ./SpeedyDine.jar

# Expose the port on which the application listens
EXPOSE 8080

# Set the entrypoint command for the container
ENTRYPOINT ["java", "-jar", "SpeedyDine.jar"]
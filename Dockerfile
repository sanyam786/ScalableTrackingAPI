# Use the official OpenJDK image as the base image
FROM openjdk:11-jre-slim

# Add a volume to store logs
VOLUME /tmp

# Copy the JAR file
COPY target/ScalableTrackingAP.jar app.jar

# Expose port 8080 (or whichever port your Spring Boot app is using)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app.jar"]
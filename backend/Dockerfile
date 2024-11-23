# Use a Java runtime image
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy and build the JAR
COPY target/backend.jar app.jar
EXPOSE 8088
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

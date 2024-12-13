FROM openjdk:17-jdk-alpine

# Install Gradle 8.11.1
RUN apk add --no-cache curl bash \
    && curl -sSL https://services.gradle.org/distributions/gradle-8.11.1-bin.zip -o gradle.zip \
    && unzip gradle.zip -d /opt \
    && rm gradle.zip \
    && ln -s /opt/gradle-8.11.1/bin/gradle /usr/bin/gradle

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and the build file(s)
COPY gradlew /app/gradlew
COPY gradle /app/gradle
COPY build.gradle /app/build.gradle
COPY settings.gradle /app/settings.gradle

# Copy the entire project into the container
COPY . /app

# Grant execute permissions to gradlew
RUN chmod +x gradlew

# Build the project
RUN ./gradlew build

RUN gradle clean build

# Expose the port that the backend application will run on
EXPOSE 8088

# Command to run the application (assuming a jar is produced by the build)
CMD ["gradle", "clean", "bootRun"]
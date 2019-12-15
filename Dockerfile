# Prepare runtime.
FROM openjdk:8-jre-alpine AS runtime
WORKDIR /app
EXPOSE 80

# Prepare build workspace.
FROM gradle:5.3.0-jdk-alpine AS sdk
WORKDIR /build-workspace

# Accept build args.
ARG ORG_GRADLE_PROJECT_mavenUser
ARG ORG_GRADLE_PROJECT_mavenPassword

# Setup build workspace.
USER root
RUN chown -R gradle .
USER gradle

# Copy.
COPY build.gradle .
COPY gradle.properties .
COPY src ./src

# Build, Test and publish.
RUN gradle clean build bootJar

# App image.
FROM runtime
COPY /build/libs/golfstats-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
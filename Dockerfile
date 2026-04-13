# Build stage
FROM eclipse-temurin:24-jdk-alpine AS build
WORKDIR /workspace
COPY . .
RUN ./gradlew clean bootJar -x test

# Runtime stage
FROM eclipse-temurin:24-jre-alpine
WORKDIR /app
COPY --from=build /workspace/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
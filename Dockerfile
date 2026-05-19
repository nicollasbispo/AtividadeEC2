FROM maven:3-eclipse-temurin-21 AS builder
LABEL authors="nicollasbispo"

WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests -Dcheckstyle.skip=true

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=builder /build/target/*.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]

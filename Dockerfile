FROM maven:3-openjdk-17 as builder

LABEL authors="lucas"

WORKDIR /build

COPY . .

RUN mvn clean package -DskipTests -Dcheckstyle.skip=true

FROM openjdk:17-slim

WORKDIR /app

COPY --from=builder /build/target/*.jar /app/app.jar

ENV ENV_API="prod"

CMD ["java", "-jar", "app.jar"]
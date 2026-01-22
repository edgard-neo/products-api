# Etapa de desenvolvimento (com hot reload)
FROM maven:3.9.6-eclipse-temurin-17 AS development
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
EXPOSE 8080
CMD ["mvn", "spring-boot:run"]

# Etapa 1: build (para produção)
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: runtime (para produção)
FROM eclipse-temurin:17-jre AS production
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
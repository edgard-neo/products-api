# ========================================
# STAGE 1: DEVELOPMENT (Hot Reload)
# ========================================
FROM maven:3.9.6-eclipse-temurin-17 AS development

WORKDIR /app

# Cache de dependências (otimização)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Código fonte (muda frequentemente)
COPY src ./src

# Porta da aplicação
EXPOSE 8080

# Comando de desenvolvimento (com hot reload)
CMD ["mvn", "spring-boot:run"]


# ========================================
# STAGE 2: BUILD (Compilação)
# ========================================
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Cache de dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Compilar aplicação
COPY src ./src
RUN mvn clean package -DskipTests


# ========================================
# STAGE 3: PRODUCTION (Runtime Otimizado)
# ========================================
FROM eclipse-temurin:17-jre-alpine AS production

WORKDIR /app

# Copiar JAR compilado do stage anterior
COPY --from=build /app/target/*.jar app.jar

# Porta da aplicação
EXPOSE 8080

# Comando de produção
ENTRYPOINT ["java", "-jar", "app.jar"]
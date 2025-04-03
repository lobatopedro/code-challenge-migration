# Etapa 1: Construção do JAR da aplicação
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Criando a imagem final
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/dummyjson-client-1.0-SNAPSHOT.jar app.jar
RUN chmod +x app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

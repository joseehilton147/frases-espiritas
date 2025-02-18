# Usa a imagem do Maven para compilar o projeto
FROM eclipse-temurin:23-jdk-alpine AS builder
WORKDIR /app

# Copia todo o código do projeto
COPY . /app

# Faz o build do projeto e gera o JAR
RUN ./mvnw clean package -DskipTests

# Usa a imagem do OpenJDK para rodar a aplicação
FROM eclipse-temurin:23-jdk-alpine
WORKDIR /app

# Copia o JAR gerado na etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Define o comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

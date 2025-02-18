# Imagem base leve com JDK 23.
# Estamos usando a imagem "eclipse-temurin:23-jdk-alpine" que traz o JDK 23 em uma versão baseada no Alpine Linux (mais leve).
FROM eclipse-temurin:23-jdk-alpine

# Define o diretório de trabalho dentro do container.
# Todos os comandos seguintes (como COPY, RUN, etc.) serão executados a partir desse diretório.
WORKDIR /app

# Copia o arquivo JAR gerado pelo Maven, que deve estar em "target/frases-espiritas.jar", para o diretório de trabalho dentro do container.
# Dessa forma, o JAR sempre terá o mesmo nome, evitando que seja necessário atualizar o Dockerfile a cada mudança de versão.
COPY target/frases-espiritas.jar frases-espiritas.jar

# Exponha a porta 8080.
# Isso indica que a aplicação Spring Boot, que por padrão roda na porta 8080, estará disponível nesta porta.
EXPOSE 8080

# Define o comando de entrada que será executado quando o container iniciar.
# Aqui, ele executa "java -jar frases-espiritas.jar" para iniciar a aplicação.
ENTRYPOINT ["java", "-jar", "frases-espiritas.jar"]
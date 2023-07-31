# Use a imagem do OpenJDK 17 como base
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR da sua aplicação Spring Boot para a imagem
COPY target/larcomsaude-backend*.jar /app/larcomsaude-backend.jar

# Exponha a porta em que a aplicação Spring Boot está ouvindo
EXPOSE 8080

# Comando para iniciar a aplicação Spring Boot quando a imagem for executada
CMD ["java", "-jar", "larcomsaude-backend.jar"]

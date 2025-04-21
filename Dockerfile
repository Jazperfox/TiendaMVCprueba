# Etapa de build con Maven y Java 21
FROM maven:3.9.4-eclipse-temurin-21 AS build

WORKDIR /app

# Copia todos los archivos del proyecto al contenedor
COPY . .

# Empaqueta el proyecto sin ejecutar tests
RUN mvn clean package -DskipTests

# Etapa final: usa una imagen ligera solo con Java para ejecutar
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia el JAR construido desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto usado por Spring Boot
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]

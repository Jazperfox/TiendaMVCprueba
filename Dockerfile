# Usa una imagen base con JDK 21 (compatible con tu configuración)
FROM eclipse-temurin:21-jdk AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos del proyecto
COPY . .

# Compila el proyecto y genera el .jar
RUN ./mvnw clean package -DskipTests

# Usa una imagen ligera para ejecutar el .jar
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copia el jar compilado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto por defecto de Spring Boot
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]

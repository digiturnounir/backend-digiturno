# Imagen base con Java 21
FROM eclipse-temurin:21-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR al contenedor
COPY target/backend-digiturno-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que usas (ajusta si es diferente)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
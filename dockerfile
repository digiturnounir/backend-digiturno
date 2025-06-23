# Imagen base con Java 21
FROM eclipse-temurin:21-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el JAR al contenedor
COPY target/backend-digiturno-0.0.1-SNAPSHOT.jar app.jar

# Copiar la carpeta del Wallet de Oracle
COPY Wallet_DIGITURNO /app/Wallet_DIGITURNO

# Expone el puerto de la aplicación
EXPOSE 8080

# Ejecuta la aplicación con la ruta TNS_ADMIN al wallet
ENTRYPOINT ["java", "-Doracle.net.tns_admin=/app/Wallet_DIGITURNO", "-jar", "app.jar"]

# Etapa 1: compilar el proyecto
FROM eclipse-temurin:21-jdk as build

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

# Etapa 2: crear imagen ligera solo con el JAR
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

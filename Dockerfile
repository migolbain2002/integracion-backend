# Utilizar una imagen base con JDK 17
FROM openjdk:17-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/LoginIntegracion-0.0.1-SNAPSHOT.jar /app/LoginIntegracion-0.0.1-SNAPSHOT.jar

# Exponer el puerto en el que se ejecuta la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación cuando el contenedor se inicia
CMD ["java", "-jar", "/app/LoginIntegracion-0.0.1-SNAPSHOT.jar"]
# Requisitos previos
- Java 17
- Maven
- Docker


# Configuraciones 

1. Clonar el repo
   - https://github.com/JulianMera/testbackendseti.git

     
2. Base de Datos
   - Se añadio un archivo "DataLoader" para inicializar la BD con datos
   
- spring.datasource.url=jdbc:mysql://localhost:3306/franquicias_db?useSSL=false&serverTimezone=UTC
- spring.datasource.username=root
- spring.datasource.password=mera1088
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.show-sql=true
- spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

  
3. Crear el JAR
   - con el comando: mvn clean package

     
4. Ejecutar en Docker (Opcional)
   - Dentro del Proyecto esta configurado el archivo Dockerfile para facilitar su empaquetamiento
     1. creamos la imaguen: docker build -t seti:1.0 .
     2. Ejecutamos la imagen creada: docker run -p 8080:8080 seti:1.0

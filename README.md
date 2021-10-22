# Spring Boot H2 Database Rest API con Spring Data JPA

Se desarrollo con eclipse el ultimo 2021

para obtener el proyecto lo bajas de git 

lo dejas en carpeta o workspace deseado

abres eclipse vas a File --> Open project from file System.... --> Directory (buscas el proyecto, seleccionas la carpeta del proyecto y finish)

## Correr Spring Boot application
RUN AS --> maven build y le pones spring:boot:run (el maven usado es el embebido de eclipse)
o
por consola dentro de carpeta proyecto utilizando comando maven (pero deberias instalar maven)
mvn spring-boot:run


## PARA VER LA BASE DE DATOS H2 (embebida)
http://localhost:8080/h2-ui/login.do

y donde dice:
JDBC URL: jdbc:h2:mem:testdb
USER NAME : sa
password : 
hacer click en botón connect y listo puedes entrar a la base de datos testdb y ver la tabla USER con los campos mail y tipo_musica donde mail es el id unico (pk)



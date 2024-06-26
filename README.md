# CodeStock Backend

Este es el backend del proyecto CodeStock, desarrollado en Java con Spring Boot y documentado con Swagger. Proporciona una API RESTful para gestionar diversas entidades.

## Tecnologías Utilizadas

- **Java Spring Boot**: Framework de aplicación de Java que proporciona un entorno robusto y escalable para el desarrollo de aplicaciones web y servicios RESTful.
- **MySQL**: Sistema de gestión de bases de datos relacional que proporciona una solución confiable y eficiente para almacenar y recuperar datos relacionales.
- **AWS**: Se utiliza AWS para desplegar la aplicación y aprovechar servicios como EC2, RDS y Lambda.
## Requisitos

- Java 8 o superior
- Maven
- Postman (opcional, para probar los endpoints)

## Instalación y Ejecución

1. Clona este repositorio: `git clone https://github.com/tuusuario/codestock.git`
2. Navega al directorio del proyecto: `cd codestock`
3. Compila el proyecto: `mvn clean install`
4. Ejecuta la aplicación: `java -jar target/codestock.jar`

La aplicación estará disponible en `http://localhost:8080`.

## Documentación de la API

La API está documentada utilizando Swagger. Puedes acceder a la documentación en `http://localhost:8080/swagger-ui.html`.

## Versionado de la API

La API sigue un esquema de versionado semántico. La versión actual es la `v1`, y los endpoints están bajo el prefijo `/api/v1/`. Futuras versiones se añadirán bajo sus respectivos prefijos de versión.
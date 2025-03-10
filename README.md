# Microservicio de Hoteles

Este microservicio se encarga de gestionar la información de los hoteles, incluyendo su disponibilidad y características. Está implementado con Spring Boot, Spring Data JPA y se registra en un Eureka Server para formar parte de una arquitectura de microservicios.

## Características

- **Listar Hoteles:** Obtiene la lista de todos los hoteles disponibles desde la base de datos.
- **Consultar Hotel por ID:** Permite obtener los detalles de un hotel específico.
- **Agregar Hotel:** Guarda un nuevo hotel en la base de datos.
- **Eliminar Hotel:** Permite eliminar un hotel existente.

## Requisitos

- **Java:** 11 o superior (compatible con Java 21)
- **Maven:** Para la construcción y gestión de dependencias.
- **MySQL:** Base de datos para almacenar la información de los hoteles.
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Spring Cloud Netflix Eureka Client:** Para el registro y descubrimiento de servicios.

## Configuración

En el archivo de configuración (por ejemplo, `src/main/resources/application.yml` o `application.properties`), debes definir la conexión a la base de datos y la configuración de Eureka. Un ejemplo básico con YAML:

```yaml
spring:
  application:
    name: microservicio-hotel
  datasource:
    url: jdbc:mysql://localhost:3306/nombre_basedatos?useSSL=false&serverTimezone=UTC
    username: usuario
    password: contraseña
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
  instance:
    prefer-ip-address: true
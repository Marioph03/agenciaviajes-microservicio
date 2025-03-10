# Microservicio de Vuelos

Este microservicio se encarga de gestionar la información de los vuelos, incluyendo la consulta de vuelos disponibles y la reserva de plazas. Se implementa con Spring Boot, Spring Data JPA y se integra opcionalmente con Eureka para el descubrimiento de servicios en una arquitectura de microservicios.

## Características

- **Listar Vuelos Disponibles:**  
  Proporciona un endpoint para obtener los vuelos que tienen al menos un número determinado de plazas disponibles.

- **Reservar Plazas en un Vuelo:**  
  Permite reservar un número específico de plazas en un vuelo, actualizando la disponibilidad en la base de datos.

- **Gestión de Vuelos:**  
  Soporta operaciones básicas para la gestión de vuelos mediante el repositorio.

## Requisitos

- **Java:** 11 o superior (compatible con Java 21).
- **Maven:** Para la construcción y gestión de dependencias.
- **MySQL:** Para almacenar la información de los vuelos.
- **Spring Boot 3.x**
- **Spring Data JPA**
- **(Opcional) Eureka Client:** Para el registro y descubrimiento de servicios en un entorno de microservicios.

## Configuración

El archivo de configuración (por ejemplo, `src/main/resources/application.yml` o `application.properties`) debe incluir los detalles de conexión a la base de datos y, si se utiliza, la configuración del cliente Eureka. A continuación, se muestra un ejemplo utilizando YAML:

```yaml
spring:
  application:
    name: microservicio-vuelos
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
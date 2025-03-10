# Eureka Server

Este proyecto implementa un **Eureka Server** utilizando Spring Boot y Spring Cloud Netflix Eureka. Su función es actuar como un servidor de descubrimiento en una arquitectura de microservicios, permitiendo que los servicios se registren y se descubran dinámicamente sin la necesidad de direcciones fijas.

## Características

- **Registro de Servicios:** Los microservicios se registran automáticamente en el Eureka Server.
- **Descubrimiento de Servicios:** Permite a los microservicios localizar otros servicios registrados.
- **Integración con Spring Cloud:** Se integra de forma nativa con otros componentes de Spring Cloud para construir una arquitectura flexible y escalable.

## Requisitos

- **Java:** 11 o superior (se recomienda utilizar Java 21, según tu entorno).
- **Maven:** Para la construcción y gestión de dependencias.
- **Spring Boot 3.x** y **Spring Cloud Netflix Eureka:** Asegúrate de utilizar versiones compatibles entre sí.

## Configuración

El archivo de configuración (por ejemplo, `src/main/resources/application.yml`) puede tener un contenido similar a:

```yaml
spring:
  application:
    name: eureka-server
server:
  port: 8761

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
  server:
    waitTimeInMsWhenSyncEmpty: 0

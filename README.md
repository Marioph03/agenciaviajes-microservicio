# API Gateway

Este proyecto implementa un **API Gateway** utilizando Spring Cloud Gateway junto con Spring Boot y Eureka para el descubrimiento de servicios. Su función es centralizar y enrutar las peticiones de los clientes a los distintos microservicios, además de aplicar políticas de seguridad y balanceo de carga.

## Características

- **Enrutamiento Dinámico:** Redirige las solicitudes a los microservicios registrados en Eureka mediante rutas configuradas.
- **Seguridad Integrada:** Utiliza Spring Security y JWT para proteger los endpoints.
- **Balanceo de Carga:** Gracias a la integración con Eureka y el uso de un `RestTemplate` con `@LoadBalanced`, distribuye las peticiones entre las instancias disponibles de cada microservicio.
- **Configuración Centralizada:** Facilita la administración y escalabilidad de la arquitectura de microservicios.

## Requisitos

- **Java:** 11 o superior (compatible con Java 21 según tu entorno).
- **Maven:** Para la construcción y gestión de dependencias.
- **Spring Boot 3.x** y **Spring Cloud Gateway**.
- **Eureka Server:** Debe estar en ejecución para que el API Gateway descubra los servicios.

## Configuración

El archivo de configuración (por ejemplo, `src/main/resources/application.yml`) puede tener un contenido similar a:

```yaml
spring:
  application:
    name: api-gateway
server:
  port: 8080

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
  instance:
    prefer-ip-address: true

# Configuración de seguridad (JWT)
security:
  jwt:
    token:
      secret-key: clave-secreta
      expire-length: 3600000

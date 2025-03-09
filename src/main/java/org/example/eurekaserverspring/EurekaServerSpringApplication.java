package org.example.eurekaserverspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/*
 * Aplicación de Agencia de Viajes basada en Microservicios
 * Tecnologías: Spring Boot, Eureka Server, API Gateway, MySQL, Spring Security, JWT
 */

// ===========================
// 1. Eureka Server
// ===========================
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerSpringApplication.class, args);
    }
}
package org.example.apigetaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableEurekaClient
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    // Definición de rutas: se enrutan las peticiones hacia los servicios registrados en Eureka.
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("ruta_hoteles", r -> r.path("/hoteles/**").uri("lb://hoteles-service"))
                .route("ruta_vuelos", r -> r.path("/vuelos/**").uri("lb://vuelos-service"))
                .route("ruta_reservas", r -> r.path("/reservations/**").uri("lb://reservas-service"))
                .build();
    }
}

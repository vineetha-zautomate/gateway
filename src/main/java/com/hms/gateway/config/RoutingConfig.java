package com.hms.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class RoutingConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("ui-configurations-api", r -> r.path("/api/configuration/**")
                        .filters(f -> f.addRequestHeader("X-Request-Source", "Gateway"))
                        .uri("http://localhost:8082"))  // Backend service URL
                .build();
    }

}


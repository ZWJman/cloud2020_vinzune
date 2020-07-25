package com.vinzune.springcloud.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/guonei")
                        .uri("https://news.baidu.com/guonei"))
                .route("path_route", r -> r.path("/guoji")
                        .uri("https://news.baidu.com/guoji"))
                .build();
    }
}

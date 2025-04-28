package com.com.github.lucasbandeira.msgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MsgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator ( RouteLocatorBuilder builder ){
		return builder.routes()
				.route(routes->routes.path("/agent/**").uri("lb://msagent"))
				.route(routes->routes.path("/hero/**").uri("lb://msmarvel"))
				.build();
	}

}


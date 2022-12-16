package br.edu.infnet.scgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
public class ScgatewayApplication {
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/vendas/**")
						.filters(f ->f.circuitBreaker(config -> config
								.setName("mycmd")
								.setFallbackUri("forward:/fallback"))
								)
						.uri("http://localhost:8987")
							)
				.route(p -> p
					.path("/compradores/**")
					.uri("http://localhost:8988")
						)
				
				.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ScgatewayApplication.class, args);
	}
	
	
	@RequestMapping("/fallback")
	public Mono<String> fallback() {
		return Mono.just("Tente mais tarde!!");
	}
}

package ma.project.tp10gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tp10GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp10GateWayApplication.class, args);
    }

    /*
    @Bean
    RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/clients/**").uri("lb://SERVICE-CLIENT"))
                .build();
    }
     */

    @Bean
    DiscoveryClientRouteDefinitionLocator routesDynamique(
            ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }

    @Bean
    RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route vers le Service Client
                .route(r -> r.path("/clients/**").uri("lb://SERVICE-CLIENT"))

                // Route vers le Service Voiture (Nouvelle route Étape 9)
                .route(r -> r.path("/voitures/**").uri("lb://SERVICE-VOITURE"))
                .build();
    }
}

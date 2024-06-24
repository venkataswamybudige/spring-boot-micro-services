package com.venkat.microservices.api_gateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gateWayRouter(RouteLocatorBuilder builder) {
        return builder.routes().
                route(predicateSpec -> predicateSpec.path("/get").
                        filters(f -> f.addRequestHeader("MyHeader", "MyURI").
                                addRequestParameter("Param","MyParam")).
                        uri("http://httpbin.org:80")).
                route(p-> p.path("/current-exchange/**").uri("lb://CURRENT-EXCHANGE-SERVICE")).
                route(p-> p.path("/currency-conversion/**").uri("lb://CURRENCY-CONVERSION-SERVICE")).
                route(p-> p.path("/currency-conversion-feign/**").uri("lb://CURRENCY-CONVERSION-SERVICE")).
                route(p-> p.path("/currency-conversion-new/**")
                                .filters(f->f.rewritePath("/currency-conversion-new/(?<segment>.*)",
                                        "/currency-conversion-feign/${segment}")).
                        uri("lb://CURRENCY-CONVERSION-SERVICE")).
                build();
    }

}

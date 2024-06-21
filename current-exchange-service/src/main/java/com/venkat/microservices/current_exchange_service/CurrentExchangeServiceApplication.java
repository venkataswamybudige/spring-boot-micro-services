package com.venkat.microservices.current_exchange_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CurrentExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrentExchangeServiceApplication.class, args);
	}

}

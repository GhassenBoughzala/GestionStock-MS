package com.esprit.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServer5twin4Application {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServer5twin4Application.class, args);
	}

}

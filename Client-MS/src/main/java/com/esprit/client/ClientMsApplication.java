package com.esprit.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ClientMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientMsApplication.class, args);
	}
	
	@Autowired
	private ClientRepository repository;
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save
			repository.save(new Client("entreprise", "56591671", "ma@esprit.tn","Vermeg","admin"));
			repository.save(new Client("entreprise", "34345567", "tunisa@esprit.tn","Tunisair","admin"));
			repository.save(new Client("entreprise", "27878909", "france@esprit.tn","talvza","admin"));
			// fetch
			repository.findAll().forEach(System.out::println);

		};
	}

}

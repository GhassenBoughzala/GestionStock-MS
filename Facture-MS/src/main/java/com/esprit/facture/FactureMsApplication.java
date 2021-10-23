package com.esprit.facture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class FactureMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactureMsApplication.class, args);
	}
	
	@Autowired
	private FactureRepository repository;
	
	@Bean
	ApplicationRunner init() {
		return (args) -> { 
			// save
			repository.save(new Facture("Mariem", "Ch", "ma@esprit.tn"));
			
			// fetch
			repository.findAll().forEach(System.out::println);

		};
	}

}

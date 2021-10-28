package com.esprit.fournisseur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class FournisseurMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FournisseurMsApplication.class, args);
	}
	
	@Autowired
	private FournisseurRepository repository;
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save
			repository.save(new Fournisseur("Test", "Test", "ma@esprit.tn","x","r"));
			repository.save(new Fournisseur("t", "t", "tunisa@esprit.tn","t","t"));
			// fetch
			repository.findAll().forEach(System.out::println);

		};
	}

}

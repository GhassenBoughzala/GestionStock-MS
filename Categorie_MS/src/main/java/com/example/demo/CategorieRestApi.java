package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorieRestApi {
private String title ="Hello Categorie service";
	
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}


}

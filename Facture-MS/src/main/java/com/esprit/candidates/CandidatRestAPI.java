package com.esprit.candidates;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidatRestAPI {
	private String title ="Hello candidate service";
	
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}

}

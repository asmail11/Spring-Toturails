package org.imdrmas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootEmbeddedServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmbeddedServiceApplication.class, args);
	}
}

@RestController
class MyRestController{
	
	@GetMapping("/")
	public String welcome() {
		return "Hello World";
	}
}

package org.imdrmas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping(value="/hello")
	public String welcome() {
		return "Welcome To Spring Boot World !";
	}

}

package org.imdrmas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootLoginApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootLoginApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoginApplication.class, args);
		
		LOGGER.error("Message Logged at ERROR Level");
		LOGGER.warn("Message Logged at WARM Level");
		LOGGER.info("Message Logged at INFO Level");
		LOGGER.debug("Message Logged at DEBUG Level");
	}
	
	@RequestMapping(value="/")
	public String welcome() {
		return "Hello World !!";
	}
}

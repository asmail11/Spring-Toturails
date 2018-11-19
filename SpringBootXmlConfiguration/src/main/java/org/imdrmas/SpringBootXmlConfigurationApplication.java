package org.imdrmas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class SpringBootXmlConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootXmlConfigurationApplication.class, args);
	}
}

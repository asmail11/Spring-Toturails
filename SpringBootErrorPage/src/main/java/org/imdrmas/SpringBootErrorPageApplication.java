package org.imdrmas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="org.imdrmas.controller")
public class SpringBootErrorPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootErrorPageApplication.class, args);
	}
}

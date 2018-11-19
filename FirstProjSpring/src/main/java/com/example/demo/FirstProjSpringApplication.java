package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProjSpringApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context = SpringApplication.run(FirstProjSpringApplication.class, args);
		
		Alien alien = context.getBean(Alien.class);
		alien.show();
		
		
	}
}

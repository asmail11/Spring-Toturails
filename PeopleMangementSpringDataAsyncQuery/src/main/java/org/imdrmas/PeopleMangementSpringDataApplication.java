package org.imdrmas;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.imdrmas.entities.Person;
import org.imdrmas.service.PeopleMangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeopleMangementSpringDataApplication implements CommandLineRunner {
	
	@Autowired
	private PeopleMangementService peopleMangementService;

	public static void main(String[] args) {
		SpringApplication.run(PeopleMangementSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        CompletableFuture<Person> completableFuture = peopleMangementService.findByEmail("drmas@gmail.com");
       Person person = completableFuture.get(20, TimeUnit.SECONDS);
        System.out.println(person);
	}



}

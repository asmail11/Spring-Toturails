package org.imdrmas;

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
		int id = 1;
		String newEmail = "imdrmas@gmail.com";
       peopleMangementService.uodatePersonEmailById(id, newEmail);
	}



}

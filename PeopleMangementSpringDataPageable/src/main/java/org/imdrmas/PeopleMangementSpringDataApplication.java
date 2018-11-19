package org.imdrmas;

import java.util.List;

import org.imdrmas.entities.Person;
import org.imdrmas.service.PeopleMangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

@SpringBootApplication
public class PeopleMangementSpringDataApplication implements CommandLineRunner {
	
	@Autowired
	private PeopleMangementService peopleMangementService;

	public static void main(String[] args) {
		SpringApplication.run(PeopleMangementSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
       List<Person> list = peopleMangementService.findByLastName("Issam",
    		   new PageRequest(1, 2, Direction.ASC, "firstName"));
	     list.forEach(System.out::println);
	     
	}



}

package org.imdrmas;

import java.util.List;

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
         getPresonInfoByLastName();
         getPersonByFirstNameAndEmail();
	}

	private void getPersonByFirstNameAndEmail() {
	    List<Person> personsList = peopleMangementService.getPersonByFirstNameAndEmail("Drmas", "drmas@gmail.com");
	    personsList.forEach(System.out::println);
		
	}

	private void getPresonInfoByLastName() {
        List<Person> personList = peopleMangementService.getPersonInfoByLastName("Issam");
        personList.forEach(System.out::println);
	}



}

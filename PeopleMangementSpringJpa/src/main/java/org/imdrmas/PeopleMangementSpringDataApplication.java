package org.imdrmas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
         // createPerson();	
		// createPersons();
		// getPersonById();
		//deletePersonEntity();
		//updatePersonEmailById();
		//getPersonInfoByLastName();
		//getPersonByFirstNameAndEmail();
	}

	private void getPersonByFirstNameAndEmail() {
		  List<Person> personList = peopleMangementService.getPersonByFirstNameAndEmail("Drmas", "drmas@gmail.com");
	        personList.forEach(System.out::println);
	}

	private void getPersonInfoByLastName() {
        List<Person> personList = peopleMangementService.getPersonInfoByLastName("Issam");
        personList.forEach(System.out::println);
	}

	private void updatePersonEmailById() {
        peopleMangementService.updatePersonEmailById(2,"ahmed2018@gmail.com");		
	}

	private void deletePersonEntity() {
	Person person = new Person();
	person.setId(3);
	peopleMangementService.deletePersonEntity(person);
	}

	private void getPersonById() {
		List<Integer> ids = new ArrayList<>();
		ids.add(2);
		ids.add(3);
		ids.add(20);
	   Iterable<Person> personList= peopleMangementService.getPersonById(ids);
	   personList.forEach(System.out::println);
	}

	private void createPersons() {
		List<Person> personList = Arrays.asList(new Person("Ahmed", "Abdallah", "ahmed@gmail.con", new Date()),
				new Person("Mohaned", "Abdallah", "mohaned@gmail.com", new Date()));
		Iterable<Person> creationPersons = peopleMangementService.createPersons(personList);
		for (Person person : creationPersons) {
			System.out.println(person);
		}
	}

	private void createPerson() {

		Person person1 = new Person("Drmas", "Issam", "drmas@gmail.com", new Date());
		Person personDb = peopleMangementService.createPerson(person1);
		System.out.println(personDb);
	}


}

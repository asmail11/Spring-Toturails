package org.imdrmas.service;

import java.util.List;

import org.imdrmas.dao.PeopleMangementDao;
import org.imdrmas.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PeopleMangementService {
	
	@Autowired
	private PeopleMangementDao peopleMangementDao;

	public Person createPerson(Person person1) {
		return peopleMangementDao.save(person1);
	}

	public Iterable<Person> createPersons(List<Person> personList) {
		Iterable<Person> list = peopleMangementDao.save(personList);
		return list;
	}

	public Iterable<Person> getPersonById(List<Integer> ids) {
		return peopleMangementDao.findAll(ids);
	}

	public void deletePersonEntity(Person person) {
		peopleMangementDao.delete(person);
		
	}

	public void updatePersonEmailById(int id, String newEmail) {
	 Person person =  peopleMangementDao.findOne(id);	
	 if (id==person.getId()) {
		person.setEmail(newEmail);
	}
	 peopleMangementDao.save(person);
	}

	public List<Person> getPersonInfoByLastName(String lastName) {
		return peopleMangementDao.findByLastName(lastName);
	}

	public List<Person> getPersonByFirstNameAndEmail(String firstName, String email) {
		return peopleMangementDao.findByFirstNameAndEmail(firstName, email);
	}


}

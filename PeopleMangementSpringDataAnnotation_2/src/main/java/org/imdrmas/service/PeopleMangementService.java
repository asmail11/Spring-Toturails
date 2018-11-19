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

	public List<Person> getPersonByFirstNameAndEmail(String firstName, String email) {
		return peopleMangementDao.findByFirstNameAndEmail(firstName, email);
	}


	public List<Person> getPersonInfoByLastName(String lastName) {
		return peopleMangementDao.getPersonInfoByLastName(lastName);
	}


}

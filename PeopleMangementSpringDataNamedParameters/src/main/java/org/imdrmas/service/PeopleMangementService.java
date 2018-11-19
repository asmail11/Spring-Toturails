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

	public List<Person> findByLastNameOrFirstName(String firstNmae, String lastName) {
		return peopleMangementDao.findByLastNameOrFirstName(firstNmae, lastName);
	}



}

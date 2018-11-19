package org.imdrmas.service;

import java.util.List;

import org.imdrmas.dao.PeopleMangementDao;
import org.imdrmas.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class PeopleMangementService {
	
	@Autowired
	private PeopleMangementDao peopleMangementDao;

	public List<Person> findByLastName(String lastName, PageRequest pageRequest) {
		return peopleMangementDao.findByLastName(lastName,pageRequest);
	}


}

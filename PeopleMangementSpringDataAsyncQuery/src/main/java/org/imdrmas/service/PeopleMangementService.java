package org.imdrmas.service;

import java.util.concurrent.CompletableFuture;

import org.imdrmas.dao.PeopleMangementDao;
import org.imdrmas.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PeopleMangementService {
	
	@Autowired
	private PeopleMangementDao peopleMangementDao;

	public CompletableFuture<Person> findByEmail(String email) {
		return peopleMangementDao.findByEmail(email);
	}


}

package org.imdrmas.dao;

import java.util.List;

import org.imdrmas.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PeopleMangementDao extends CrudRepository<Person, Integer> {
	List<Person> getPersonInfoByLastName(String lastName);
	List<Person> findByFirstNameAndEmail(String firstName, String email);
}

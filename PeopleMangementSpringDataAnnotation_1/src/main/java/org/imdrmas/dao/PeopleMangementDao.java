package org.imdrmas.dao;

import java.util.List;

import org.imdrmas.entities.Person;

import org.springframework.data.repository.CrudRepository;

public interface PeopleMangementDao extends CrudRepository<Person, Integer> {
	@com.datastax.driver.mapping.annotations.Query(value = "SELECT p FROM Person p WHERE p.lastName=?1")
	List<Person> getPersonInfoByLastName(String lastName);
	
	@com.datastax.driver.mapping.annotations.Query(value="SELECT p FROM Person p WHERE p.firstName=?1 AND email=?2")
	List<Person> findByFirstNameAndEmail(String firstName, String email);
}
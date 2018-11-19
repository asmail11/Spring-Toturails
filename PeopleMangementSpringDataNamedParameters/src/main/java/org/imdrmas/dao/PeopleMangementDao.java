package org.imdrmas.dao;

import java.util.List;

import org.imdrmas.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

public interface PeopleMangementDao extends CrudRepository<Person, Integer> {

	@Query("SELECT p FROM Person p WHERE p.firstName=:firstname OR p.lastName=:lastname")
	List<Person> findByLastNameOrFirstName(@Param("lastname") String firstNmae, @Param("firstname")String lastName);


}

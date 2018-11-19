package org.imdrmas.dao;

import java.util.List;

import org.imdrmas.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PeopleMangementDao extends CrudRepository<Person, Integer> {

	@Query(value="SELECT * FROM person_table WHERE last_name=?1",nativeQuery=true)
	List<Person> getPersonInfoByLastName(String lastName);
	
    @Query(value="SELECT * FROM person_table WHERE first_name=?1 AND email=?2",nativeQuery=true)
	List<Person> findByFirstNameAndEmail(String firstName, String email);
}

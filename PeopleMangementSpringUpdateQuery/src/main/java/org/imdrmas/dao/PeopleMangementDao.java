package org.imdrmas.dao;


import javax.transaction.Transactional;

import org.imdrmas.entities.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

public interface PeopleMangementDao extends CrudRepository<Person, Integer> {

	@Transactional
	@Modifying(clearAutomatically=true) //not Require = clearAutomatically=true
	@Query(value="UPDATE Person set email=:newEmail WHERE id=:personId")
	void uodatePersonEmailById(@Param("personId")int id, @Param("newEmail")String newEmail);


}

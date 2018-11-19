package org.imdrmas.dao;
import java.util.concurrent.CompletableFuture;

import org.imdrmas.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PeopleMangementDao extends CrudRepository<Person, Integer> {

	CompletableFuture<Person> findByEmail(String email);

}

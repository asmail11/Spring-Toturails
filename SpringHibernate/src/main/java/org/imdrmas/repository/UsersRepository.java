package org.imdrmas.repository;

import java.util.List;

import org.imdrmas.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
      List<Users> findByName(String name);
	  Users findOne(Integer id);
}

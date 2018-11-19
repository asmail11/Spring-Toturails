package org.imdrmas.repository;

import org.imdrmas.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
public UserInfo findByUserName(String username);
}

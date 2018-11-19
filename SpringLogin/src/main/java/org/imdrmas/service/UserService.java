package org.imdrmas.service;

import org.imdrmas.model.User;

public interface UserService {
	
	public User findUserByEmail(String email);
	public void saveUser(User user);

}

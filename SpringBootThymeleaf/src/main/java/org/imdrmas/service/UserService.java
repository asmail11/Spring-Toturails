package org.imdrmas.service;

import java.util.ArrayList;
import java.util.List;

import org.imdrmas.model.User;
import org.springframework.stereotype.Service;
@Service
public class UserService {
	
	private List<User> userList = new ArrayList<>();
	
	public List<User> getAllUsers(){
		return userList;
	}
	public void addUser(User user) {
		userList.add(user);
	}
	


}

package org.imdrmas.service.impl;

import org.imdrmas.entities.UserInfo;
import org.imdrmas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = this.userRepository.findByUserName(username);
		
		if (userInfo == null) {
			throw new UsernameNotFoundException(String.format("No User found with username '%s'.", username));
		}
		return null;
	
	}

}

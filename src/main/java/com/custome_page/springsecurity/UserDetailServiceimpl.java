package com.custome_page.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.custome_page.bean.User;
import com.custome_page.repo.Repo;

public class UserDetailServiceimpl implements UserDetailsService {
	
	@Autowired
	private Repo userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//fetching user from database
		
		User userByEmail = userRepository.getUserByUserName(username);
	 
		if(userByEmail==null) {
			throw new UsernameNotFoundException("Could not found user !! ");
		}
		
		CustomerUserDetails customerUserDetails = new CustomerUserDetails(userByEmail);
		
		
		
		return customerUserDetails;
	}

}
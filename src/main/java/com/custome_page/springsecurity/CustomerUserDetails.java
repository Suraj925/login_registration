package com.custome_page.springsecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.custome_page.bean.User;


public class CustomerUserDetails implements UserDetails {
	
	private User user;

	public CustomerUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());
		 List<SimpleGrantedAuthority> users=new ArrayList<>();
		 users.add(simpleGrantedAuthority);
		return users;
	}

	@Override
	public String getPassword() {
		 
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		 
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

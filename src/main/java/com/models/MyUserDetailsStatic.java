package com.models;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetailsStatic implements UserDetails {
	
	private String username;
	
	public MyUserDetailsStatic(String username) {
		this.username = username;
	}
	
	public MyUserDetailsStatic() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//		GrantedAuthority authority = new SimpleGrantedAuthority("");
//		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return "pass";
	}

	@Override
	public String getUsername() {
		return username;
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

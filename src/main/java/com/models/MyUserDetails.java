package com.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	
	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> grantedAuthorities;
	
	public MyUserDetails(String username) {
		this.username = username;
	}
	
	public MyUserDetails(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.grantedAuthorities = Arrays.stream(user.getRoles().split(","))
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList());
	}
	
	public MyUserDetails() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
//		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//		GrantedAuthority authority = new SimpleGrantedAuthority("");
//		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return password;
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

package com.apurav.medialibrary.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAuthentication implements Authentication {

	private static final long serialVersionUID = 1L;
	private final UserDetails user;
	private boolean authenticated = true;

	public UserAuthentication(UserDetails user) {
		this.user = user;
	}

	public String getName() {
		return user.getUsername();
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.getAuthorities();
	}

	public Object getCredentials() {
		return user.getPassword();
	}

	public UserDetails getDetails() {
		return user;
	}

	public Object getPrincipal() {
		return user.getUsername();
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
}

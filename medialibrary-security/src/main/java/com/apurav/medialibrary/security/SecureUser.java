package com.apurav.medialibrary.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.apurav.medialibrary.commons.dto.User;
import com.apurav.medialibrary.commons.dto.User.Role;

public class SecureUser implements UserDetails {
	private static final long serialVersionUID = 1L;
	private User user;

	public SecureUser() {
	}

	public SecureUser(User user) {
		this.user = user;
	}

	
	public User getUser() {
		return this.user;
	}
	public boolean isEnabled() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		Boolean locked = this.user.getLocked();
		if (locked != null)
			return !locked;
		return true;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public String getUsername() {
		return this.user.getMail();
	}

	public String getPassword() {
		return this.user.getPass();
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.user != null && this.user.getRole() != null) {
			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			for (Role role : this.user.getRole()) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role.name());
				authorities.add(authority);
			}
			return authorities;
		}
		return null;
	}


	
}

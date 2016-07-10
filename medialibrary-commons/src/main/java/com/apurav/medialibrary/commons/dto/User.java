package com.apurav.medialibrary.commons.dto;

import java.util.Date;
import java.util.Set;
/**
 * 
 * @author apuravchauhan
 *
 */
public class User {
	
	public static enum Role{
		USR
	}
	private String id;
	private String name;
	private String sex;
	private String mail;
	private String mob;
	private String pass;
	private Boolean locked;
	private Set<Role> role;
	private Date cr;
	
	public User() {
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	public User(String name, String sex, String mail, String mob, String pass) {
		super();
		this.name = name;
		this.sex = sex;
		this.mail = mail;
		this.mob = mob;
		this.pass = pass;
	}
	public User(String name, String sex, String mail) {
		super();
		this.name = name;
		this.sex = sex;
		this.mail = mail;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> roleSet) {
		this.role = roleSet;
		/*if (this.role != null) {
			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			for (Role role : this.role) {
				GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role.name());
				authorities.add(authority);
			}
			this.authorities= authorities;
		}*/
	}
	/*public Collection<? extends GrantedAuthority> getAuthorities() {
		if (role != null) {
			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			for (Role role : this.role) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role.name());
				authorities.add(authority);
			}
			return authorities;
		}
		return this.authorities;
	}*/
	public String getPassword() {
		return pass;
	}
	public String getUsername() {
		return mail;
	}
	public boolean isAccountNonExpired() {
		return true;
	}
	public boolean isAccountNonLocked() {
		Boolean locked = this.locked;
		if (locked != null)
			return !locked;
		return true;
	}
	public boolean isCredentialsNonExpired() {
		return true;
	}
	public boolean isEnabled() {
		return true;
	}
	public Date getCr() {
		return cr;
	}
	public void setCr(Date cr) {
		this.cr = cr;
	}
	
	
	
	
}

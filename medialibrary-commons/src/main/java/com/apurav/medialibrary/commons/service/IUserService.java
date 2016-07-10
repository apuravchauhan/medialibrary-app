package com.apurav.medialibrary.commons.service;

import com.apurav.medialibrary.commons.dto.User;

/**
 * 
 * @author apurav.chauhan
 *
 */
public interface IUserService {

	public User signup(User user);

	public User loadUserByUsername(String mail);
}

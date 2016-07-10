package com.apurav.medialibrary.core.dao;

import com.apurav.medialibrary.commons.dto.User;

/**
 * 
 * @author apurav.chauhan
 *
 */
public interface IUserDao {

	public User add(User user);
	public User findByMail(String mail);
	public User findById(String id);
	public void updatePref(String id,String mobile,Boolean privacy);
}

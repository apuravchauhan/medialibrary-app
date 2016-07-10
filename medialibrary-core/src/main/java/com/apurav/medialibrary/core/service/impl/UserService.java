package com.apurav.medialibrary.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apurav.medialibrary.commons.dto.User;
import com.apurav.medialibrary.commons.service.IUserService;
import com.apurav.medialibrary.core.dao.IUserDao;

/**
 * 
 * @author apurav.chauhan
 *
 */
@Service
public class UserService implements IUserService{

	@Autowired
	private IUserDao userDao;

	public User loadUserByUsername(String username)  {
		return userDao.findByMail(username);
	}

	@Override
	public User signup(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	

}

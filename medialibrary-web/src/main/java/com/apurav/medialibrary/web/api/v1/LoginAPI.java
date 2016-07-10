package com.apurav.medialibrary.web.api.v1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apurav.medialibrary.commons.dto.User;
import com.apurav.medialibrary.commons.service.IUserService;
import com.apurav.medialibrary.security.SecurityUtils;

@RestController
public class LoginAPI {
	
	@Autowired
	private IUserService userService;
	
	private PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
	
	@RequestMapping(value="/api/v1/login",method=RequestMethod.POST)
	public User login(@RequestBody User requestUser,HttpServletResponse resp) throws Exception{
		User user = (User)userService.loadUserByUsername(requestUser.getMail());
		if(user!=null){
			SecurityUtils.setLoggedInUser(user);
	
		}
		return user;
		
	}
	@RequestMapping(value="/api/v1/signup",method=RequestMethod.POST)
	public User signup(@RequestBody User user,HttpServletResponse resp) throws Exception{
		//add validations b4 signup
		userService.signup(user);
		SecurityUtils.setLoggedInUser(user);
        return user;
		
	}
	@RequestMapping(value="/api/v1/logout",method=RequestMethod.POST)
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		SecurityContextHolder.clearContext();
	}
	
}

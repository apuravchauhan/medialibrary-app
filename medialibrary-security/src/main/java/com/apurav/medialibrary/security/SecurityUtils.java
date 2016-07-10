package com.apurav.medialibrary.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.apurav.medialibrary.commons.dto.User;
/**
 * 
 * @author apuravchauhan
 *
 */
public class SecurityUtils {

	
	public static User getLoggedInUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null && auth instanceof UserAuthentication){
			return (User)auth.getDetails();
		}
		return null;
		
	}
	
	public static void setLoggedInUser(User user){
		SecureUser secureUser = new SecureUser(user);
		UserAuthentication authentication = new UserAuthentication(secureUser);
        SecurityContextHolder.getContext().setAuthentication(authentication);
		
		
	}
}

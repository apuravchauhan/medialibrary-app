package com.apurav.medialibrary.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author apuravchauhan
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/home";
	}
	
	@RequestMapping("/home/**")
	public String upload() {
		return "home";
	}
	
	

}

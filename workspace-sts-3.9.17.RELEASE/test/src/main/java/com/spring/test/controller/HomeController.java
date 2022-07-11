package com.spring.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.test.dto.User;
import com.spring.test.service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	HomeService homeService;

	@RequestMapping(value = "/t", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		model.addAttribute("hi", "Hello test" );
		
		return "home";
	}
	
	@RequestMapping(value = "test.do", method = RequestMethod.GET)
	public String get(User user) {
		
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getAge());
		System.out.println(user.getJob());
		
		return "home";
	}
	
	@RequestMapping(value = "test1.do", method = RequestMethod.POST)
	public String post(User user) {
		
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getAge());
		System.out.println(user.getJob());
		
		return "home";
	}
}

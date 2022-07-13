package com.spring.boardweb.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/join.do")
	public String join() {
		return "user/join"; // view resolve가 WEB-INF/views 까지니까 
	}
	
	@RequestMapping("/login.do")
	public String login() {
		return "user/login";
	}
	
}

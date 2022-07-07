package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {	
		model.addAttribute("hi", "Hello Spring" );
		return "home";
	}
	
	// Modl.addAttribute를 이용해서 
	//src/main/webapp/WEB-INF/views/home.jsp 에서 ${hi}부분을 Hello Spring으로 매핑
	
	//servers/Tomcat*/server.xml 맨 아래에서 Controller mapping 주소 수정
	
	//왼쪽 아래 Servers에서 우클릭 Add and remove 에서 프로젝트 추가하여 실행
	
	//Properties에서 Project Facets 에서 Java 버전이랑 Runtimes에서 톰캣지정
}

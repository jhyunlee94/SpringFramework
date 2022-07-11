package com.spring.boardweb.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boardweb.HomeVO;
import com.spring.boardweb.service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//Autowired는 의존성을 주입할 때 모양만 비교를 함
	//HomeService 모양으로 생성된 객체가 있는지 없는지 찾음
	//있으면 주입 없으면 에러
	//HomeService 모양이 여러개면 존재하면 에러가 발생
//	@Autowired // homeService = new HomeServiceImpl(); 
	
	//여러개일때 사용하는거
	//@Qualifier는 의존성을 주입할 때 모양과 이름을 비교함
	//같은 모양의 객체가 여러개 존재할 때 이름으로 비교하여 의존성 주입한다.
	@Autowired
	HomeService homeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		
		model.addAttribute("hi", "Hello Spring" );
		
		//1. Session Scope
//		System.out.println("session data =======" + session.getAttribute("hello"));
		
		return "home";
	}
	
	
	//화면단에서 전달되는 파라미터 받기
	//1. @RequestParam 어노테이션을 이용하여 변수에 할당
//	@RequestMapping(value = "test.do", method = RequestMethod.GET)
//	public String testGet(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
//		System.out.println("get 요청");
//		System.out.println("get firstName =========" + firstName );
//		System.out.println("get lastName =========" + lastName );
//		return "home";
//	}
//
//	@RequestMapping(value = "test.do", method = RequestMethod.POST)
//	public String testPost(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
//		System.out.println("Post 요청");
//		System.out.println("post firstName =========" + firstName );
//		System.out.println("post lastName =========" + lastName );
//		return "home";
//	}
	
//	2. @RequestParam 어노테이션을 이용하여 Map에 할당
	@RequestMapping(value = "test.do", method = RequestMethod.GET)
	public String testGet(@RequestParam Map<String, Object> paramMap) {
		//Map<String, Object> Object 쓴 이유는 string, number, boolean, array, object 를 다 받을 수있기때문에 object로
		System.out.println("get 요청");
		System.out.println("get firstName =========" + paramMap.get("firstName"));
		System.out.println("get lastName =========" + paramMap.get("lastName"));
		System.out.println("get age =========" + paramMap.get("age"));
		System.out.println("get job =========" + paramMap.get("job"));


		return "home";
	}

	@RequestMapping(value = "test.do", method = RequestMethod.POST)
	public String testPost(@RequestParam Map<String, Object> paramMap) { // Map은 무조건 키 밸류가 있어야해서 Map<,> 두개가 들어가야함
		System.out.println("Post 요청");
		System.out.println("post firstName =========" + paramMap.get("firstName") );
		System.out.println("post lastName =========" + paramMap.get("lastName"));
		System.out.println("get age =========" + paramMap.get("age"));
		System.out.println("get job =========" + paramMap.get("job"));

		// servlet-context.xml 에서 /WEB-INF/views/home.jsp로 이동
		//"redirect:경로"를 쓰면 뷰리졸브를 이용하지 않고 이동하게됨
		// redirect: 주소 설정 시 viewResolver를 타지 않고
		// 원하는 주소로 바로 이동하도록 설정 가능
		// redirect 시 주소도 이동할 주소로 변경됨
		
//		paramMap.forEach((key, value) -> {
//			System.out.println("key" +key);
//			System.out.println("value" +value);
//		});
		
//		Iterator<Entry<String, Object>> a = paramMap.entrySet().iterator();
//		
//		while(a.hasNext()) {
//			System.out.println(a.next());
//		}
//		
		
		return "redirect:/";
//		return "home";
	}
	
//	//3.Command 객체를 이용하여 파라미터 받기
//	// Command 객체 : 함수의 매개변수안에 선언된 객체
//	@RequestMapping(value = "test.do", method = RequestMethod.GET)
//	public String testGet(HomeVO homeVO) {
//		//Map<String, Object> Object 쓴 이유는 string, number, boolean, array, object 를 다 받을 수있기때문에 object로
//		System.out.println("get 요청");
//		System.out.println("get firstName =========" + homeVO.getFirstName());
//		System.out.println("get lastName =========" + homeVO.getLastName());
//		System.out.println("get age =========" + homeVO.getAge());
//		System.out.println("get job =========" + homeVO.getJob());
//
//
//		return "home";
//	}
//
//	@RequestMapping(value = "test.do", method = RequestMethod.POST)
//	public String testPost(HomeVO homeVO) { // Map은 무조건 키 밸류가 있어야해서 Map<,> 두개가 들어가야함
//		System.out.println("Post 요청");
//		System.out.println("Post firstName =========" + homeVO.getFirstName());
//		System.out.println("Post lastName =========" + homeVO.getLastName());
//		System.out.println("Post age =========" + homeVO.getAge());
//		System.out.println("Post job =========" + homeVO.getJob());
//
//		// servlet-context.xml 에서 /WEB-INF/views/home.jsp로 이동
//		//"redirect:경로"를 쓰면 뷰리졸브를 이용하지 않고 이동하게됨
//		// redirect: 주소 설정 시 viewResolver를 타지 않고
//		// 원하는 주소로 바로 이동하도록 설정 가능
//		// redirect 시 주소도 이동할 주소로 변경됨
//		
//		return "redirect:/";
////		return "home";
//	}
	
	@RequestMapping("/hello.do")
	public String hello(HttpSession session, Model model) {
		//1. Session Scope 
//		session.setAttribute("hello", "12345");
		
		//2. Request Scope
		model.addAttribute("hello", "12345"); // hello에 12345 를 담아서 이동
		//model은 하나만 이동가능
		
		return "hello";
	}
	
	@RequestMapping("getNameList.do")
	public String getNameList(Model model) {
		//목록이 오는거니까 List로
		List<HomeVO> resultList = homeService.getNameList();
		model.addAttribute("nameList", resultList); 
		
		for(int i = 0; i < resultList.size(); i++) {
			System.out.println("firstName=========" + resultList.get(i).getFirstName());
			System.out.println("lastName=========" + resultList.get(i).getLastName());
		}
			
		return "getNameList";
	}
	
}

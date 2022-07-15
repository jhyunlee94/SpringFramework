package com.spring.boardweb.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.boardweb.UserVO;
import com.spring.boardweb.service.user.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
//	@RequestMapping(value = "/join.do", method=RequestMethod.GET)
//	public String joinView() {
//		return "user/join"; // view resolve가 WEB-INF/views 까지니까 
//	}
//	
//	@RequestMapping(value = "/join.do", method=RequestMethod.POST)
//	public String join() {
//		return "user/join"; // view resolve가 WEB-INF/views 까지니까 
//	}
	
	@RequestMapping("/join.do")
	public String join(UserVO userVO) {
		//회원가입 정보가 넘어오지 않았을 때는 회원가입 화면으로
		if(userVO.getUserId() == null || userVO.getUserId().equals("")) {
			return "user/join";
		}
		
		//회원가입 정보가 넘어왔을 때는 회원가입 처리 후 로그인 화면으로
		userService.join(userVO);
		return "user/login"; // view resolve가 WEB-INF/views 까지니까 
	}
	
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String loginView() {
		//GET방식이 오면 화면단으로
		return "user/login";
	}
	
	
	@RequestMapping(value= "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public String login(HttpSession session, UserVO userVO) throws JsonProcessingException {
		//UserVO는 input 값이 넘어올수 있도록 사용하는거
		//로그인은 다른페이지 이동해도 사용할수있게 세션에 담아줘야한다.
		//세션에 로그인 정보가 없으면 로그인 화면으로 이동
//		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
//		//로그인 폼의 인풋 정보가 없으면 로그인 화면으로 이동
//		if(userVO.getUserId() == null || userVO.getUserId().equals("")) {
//			return "user/login";
//		}
//		
		//Json 객체로 반환해주는 클래스 ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		
		//1. 존재하는 아이디인지 체크
		int idCheck = userService.idCheck(userVO.getUserId());
		
		if(idCheck < 1) {
			jsonMap.put("message", "idFail");
		} else {
			//2. 패스워드 확인
			int pwCheck = userService.pwCheck(userVO);
			
			if(pwCheck < 1) {
				jsonMap.put("message", "pwFail");
			} else {
				//3. 로그인 처리
				UserVO user = userService.login(userVO);
				
				session.setAttribute("loginUser", user);
				
				jsonMap.put("message", "loginSucccess");
			}
		}
		
		String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
		
		return jsonStr;
	}
	
	@RequestMapping("/idCheck.do")
	//ViewResolver를 타게 되면 ResponseBody를 HTML 구조로 만들어서 화면을 리턴
	//ViewResolver를 안태우고 반환 값 자체를 ResponseBody로 만들려면 @ResponseBody 사용
	@ResponseBody
	public String idCheck(UserVO userVO) throws JsonProcessingException {
		//Json 객체로 반환해주는 클래스 ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int resultIdCheck = userService.idCheck(userVO.getUserId());
		
		jsonMap.put("resultIdCheck", resultIdCheck); // 0, 1 을 담아준다.
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
		System.out.println("jsonString============" + json);
		return json;
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		//세션내에 저장되어있는 내용들을 초기화
		session.invalidate();
		
		
		// index.jsp 는 WEB-INF 밖에 있기에 redirect로 보내줘야한다.
		return "redirect:/index.jsp";
	}
	
}

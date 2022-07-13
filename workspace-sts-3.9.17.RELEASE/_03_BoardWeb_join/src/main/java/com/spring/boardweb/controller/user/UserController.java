package com.spring.boardweb.controller.user;

import java.util.HashMap;
import java.util.Map;

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
	
	
	@RequestMapping("/login.do")
	public String login() {
		return "user/login";
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
	
}

package com.spring.boardweb.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.boardweb.UserVOA;
import com.spring.boardweb.service.user.UserServiceA;

@Controller
@RequestMapping("/user")
@EnableWebMvc
public class UserControllerA {
	
	@Autowired
	UserServiceA userServiceA;
	
	@RequestMapping(value = "/joinA.do", method=RequestMethod.GET)
	public String joinView() {
		return "user/joinA";
	}
	
	@RequestMapping(value = "/joinA.do", method=RequestMethod.POST)
	public String join(UserVOA userVOA) {
//		//회원가입 정보가 넘어오지 않았을 때는 회원가입 화면으로
//		if(userVOA.getUserId() == null || userVOA.getUserId().equals("")) {
//			return "user/joinA";
//		}
		userServiceA.join(userVOA);
		
		return "user/joinA";
	}
	

	@RequestMapping("/idCheckA.do")
	@ResponseBody
	public String idCheck1(UserVOA userVOA) throws JsonProcessingException {
		// json 으로 변경
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int resultIdCheck = userServiceA.idCheck1(userVOA.getUserId());
		
		//변환 값을 json으로 담아서 보내줘야함
		jsonMap.put("resultIdCheck", resultIdCheck);
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
		System.out.println("jsonString==========" + json);
		
		return json;
	}
	
}

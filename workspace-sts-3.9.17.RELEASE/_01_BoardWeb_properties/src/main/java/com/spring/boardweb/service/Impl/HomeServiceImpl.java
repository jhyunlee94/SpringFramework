package com.spring.boardweb.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boardweb.HomeVO;
import com.spring.boardweb.service.HomeService;


//어노테이션으로 별칭을 만들어 줄수 있다.
//별칭없이 생성하면 클래스명에서 첫글자만 소문자로 변경된 이름으로 객체 생성
@Service // 서비스객체라고 스프링 컨테이너 알려줌,  @Service("별칭") 별칭 지정 가능
public class HomeServiceImpl implements HomeService{

	@Autowired
	HomeDAO homeDAO;
	
	@Override
	public List<HomeVO> getNameList() {
		return homeDAO.getNameList();
	}
	//<context:component-scan base-package="com.spring.boardweb.service" /> - root-context.xml에 추가해줘야함
	//	<context:component-scan base-package="com.spring.boardweb.controller" /> - servlet-context.xml에 자식만 추가해줘야함
	//왜냐 그래야지 service를 먼저 객체를 생성하고 그 다음 controller에서 사용을 하니 servlet-context.xml 즉 자식컨테이너에 추가

	@Override
	public void insertName(HomeVO homeVO) {
		// TODO Auto-generated method stub
		homeDAO.insertName(homeVO);
		
	}

	@Override
	public void updateName(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		homeDAO.updateName(paramMap);
	}

	@Override
	public void deleteName(HomeVO homeVO) {
		// TODO Auto-generated method stub
		homeDAO.deleteName(homeVO);
	}

}

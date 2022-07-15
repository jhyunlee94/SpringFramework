package com.spring.boardweb.service.user.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boardweb.UserVO;

@Repository
public class UserDAO {

	@Autowired
	SqlSessionTemplate mybatis;
	
	public void join(UserVO userVO) {
		// TODO Auto-generated method stub
		mybatis.insert("UserDAO.join", userVO);
	}

	public int idCheck(String userId) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("UserDAO.idCheck", userId);
	}

	public int pwCheck(UserVO userVO) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("UserDAO.pwCheck", userVO);
	}

	public UserVO login(UserVO userVO) {
		// TODO Auto-generated method stub
		return (UserVO) mybatis.selectOne("UserDAO.login", userVO);
	}

}

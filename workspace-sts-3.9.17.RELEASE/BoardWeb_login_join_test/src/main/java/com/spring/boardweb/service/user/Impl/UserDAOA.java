package com.spring.boardweb.service.user.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boardweb.UserVOA;

@Repository
public class UserDAOA {
	
	@Autowired
	SqlSessionTemplate mybatis;
	

	public void join(UserVOA userVOA) {
		// TODO Auto-generated method stub
		mybatis.insert("UserDAOA.join", userVOA);
	}


	public int idCheck1(String userId) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("UserDAOA.idCheck1", userId);
	}


	public int pwCheckA(UserVOA userVOA) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("UserDAOA.pwCheckA", userVOA);
	}


	public UserVOA loginA(UserVOA userVOA) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("UserDAOA.loginA", userVOA);
	}



}

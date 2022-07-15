package com.spring.boardweb.service.user.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boardweb.UserVOA;
import com.spring.boardweb.service.user.UserServiceA;

@Service
public class UserServiceImplA implements UserServiceA {

	@Autowired
	UserDAOA userDAOA;
	
	
	@Override
	public void join(UserVOA userVOA) {
		// TODO Auto-generated method stub
		userDAOA.join(userVOA);
	}


	@Override
	public int idCheck1(String userId) {
		// TODO Auto-generated method stub
		return userDAOA.idCheck1(userId);
	}


	@Override
	public int pwCheckA(UserVOA userVOA) {
		// TODO Auto-generated method stub
		return userDAOA.pwCheckA(userVOA);
	}


	@Override
	public UserVOA loginA(UserVOA userVOA) {
		// TODO Auto-generated method stub
		return userDAOA.loginA(userVOA);
	}



}

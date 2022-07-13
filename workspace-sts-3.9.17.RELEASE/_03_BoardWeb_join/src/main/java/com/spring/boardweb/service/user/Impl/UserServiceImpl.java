package com.spring.boardweb.service.user.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boardweb.UserVO;
import com.spring.boardweb.service.user.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public void join(UserVO userVO) {
		// TODO Auto-generated method stub
		userDAO.join(userVO);
	}

	@Override
	public int idCheck(String userId) {
		// TODO Auto-generated method stub
		return userDAO.idCheck(userId);
	}

}

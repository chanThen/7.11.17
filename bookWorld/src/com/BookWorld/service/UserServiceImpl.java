package com.BookWorld.service;

import com.BookWorld.dao.UserDao;
import com.BookWorld.dao.UserDaoImpl;
import com.BookWorld.model.User;

public class UserServiceImpl implements UserService{

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User findUserByEmail(String email ,String pwd) {
		
		return userDao.findUserByEmail(email,pwd);
	}

	@Override
	public String addUser(User user) {
		
		return userDao.addUser(user);
	}
}

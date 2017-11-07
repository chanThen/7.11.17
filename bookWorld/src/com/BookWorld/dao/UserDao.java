package com.BookWorld.dao;

import com.BookWorld.model.User;

public interface UserDao {

	public User findUserByEmail(String email, String pwd);

	public String addUser(User user);

	
}

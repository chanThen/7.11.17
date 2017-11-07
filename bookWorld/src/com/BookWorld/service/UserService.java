package com.BookWorld.service;

import com.BookWorld.model.User;

public interface UserService {
	
	public User findUserByEmail(String email, String pwd);
	
	public String addUser(User user);

}

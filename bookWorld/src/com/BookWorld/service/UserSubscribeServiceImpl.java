package com.BookWorld.service;

import java.util.List;

import com.BookWorld.dao.UserSubscribeDao;
import com.BookWorld.dao.UserSubscribeDaoImpl;
import com.BookWorld.model.BookDetail;
import com.BookWorld.model.UserSubscribe;

public class UserSubscribeServiceImpl implements UserSubscribeService {

	UserSubscribeDao userSubscribeDao = new UserSubscribeDaoImpl();

	@Override
	public UserSubscribe checkForSubscription(int bookId, int userId) {
		
		return userSubscribeDao.checkForSubscription(bookId, userId);
	}

	@Override
	public String addToSubscribeList(UserSubscribe userSubscribe) {
		
		return userSubscribeDao.addToSubscribeList(userSubscribe);
	}

	@Override
	public BookDetail getBookDetail(int bookId) {
		
		return userSubscribeDao.getBookDetail(bookId);
	
	}

	@Override
	public List<UserSubscribe> getAllSubscribedListByUserId(int userId) {
		
		return userSubscribeDao.getAllSubscribedListByUserId(userId);
	}
	
}

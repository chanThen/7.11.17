package com.BookWorld.dao;

import java.util.List;

import com.BookWorld.model.BookDetail;
import com.BookWorld.model.UserSubscribe;

public interface UserSubscribeDao {

	String addToSubscribeList(UserSubscribe userSubscribe);

	UserSubscribe checkForSubscription(int bookId, int userId);

	BookDetail getBookDetail(int bookId);

	List<UserSubscribe> getAllSubscribedListByUserId(int userId);

}

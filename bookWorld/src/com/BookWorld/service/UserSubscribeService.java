package com.BookWorld.service;

import java.util.List;

import com.BookWorld.model.BookDetail;
import com.BookWorld.model.UserSubscribe;
import com.BookWorld.model.UserWishList;

public interface UserSubscribeService {

	String addToSubscribeList(UserSubscribe userSubscribe);

	UserSubscribe checkForSubscription(int bookId, int userId);

	BookDetail getBookDetail(int bookId);

	List<UserSubscribe> getAllSubscribedListByUserId(int userId);
}
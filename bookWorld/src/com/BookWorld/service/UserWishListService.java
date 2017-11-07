package com.BookWorld.service;

import java.util.List;

import com.BookWorld.model.BookDetail;
import com.BookWorld.model.UserWishList;

public interface UserWishListService {

	String addToWishList(UserWishList userwishList);

	boolean checkWishList(int userId,int bookId);

	BookDetail getBookDetail(int bookId);

	List<UserWishList> getAllWishListByUserId(int userId);

	String deleteSelectedWishList(int wishListId);

}

package com.BookWorld.service;

import java.util.List;

import com.BookWorld.dao.UserWishListDao;
import com.BookWorld.dao.UserWishListDaoImpl;
import com.BookWorld.model.BookDetail;
import com.BookWorld.model.UserWishList;

public class UserWishListServiceImpl implements UserWishListService{

	UserWishListDao userwishlistdao = new UserWishListDaoImpl();
	@Override
	public String addToWishList(UserWishList userwishList) {
		
		return userwishlistdao.addToWishList(userwishList);
	}
	
	//Check The WishList Table for existing Book
	@Override
	public boolean checkWishList(int userId,int bookId) {
		
		return userwishlistdao.checkWishList(userId,bookId);
	}
	
	@Override
	public BookDetail getBookDetail(int bookId) {
		
		return userwishlistdao.getBookDetail(bookId);
	}

	@Override
	public List<UserWishList> getAllWishListByUserId(int userId) {
		
		return userwishlistdao.getAllWishListByUserId(userId);
	}

	@Override
	public String deleteSelectedWishList(int wishListId) {
		
		return userwishlistdao.deleteSelectedWishList(wishListId);
	}

}

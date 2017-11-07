package com.BookWorld.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.BookWorld.model.BookDetail;
import com.BookWorld.model.UserWishList;
import com.BookWorld.service.UserWishListService;
import com.BookWorld.service.UserWishListServiceImpl;

@Path("/wishList")
public class UserWishListController {
	
	UserWishListService userWishListService = new UserWishListServiceImpl();
	
	@Path("/addToWishList")
	@POST
	public String addToWishList(@QueryParam("bookId") int bookId,
								@QueryParam("userId")int userId) {
		
		UserWishList userWishList = new UserWishList();
		
		boolean isBookExistInWishList = checkWishList(bookId,userId);
		
		if (isBookExistInWishList == false) {
		
			BookDetail bookDetail = new BookDetail();
			bookDetail = getBookDetail(bookId);
			userWishList.setBookDetail(bookDetail);
			userWishList.setUserId(userId);
			return userWishListService.addToWishList(userWishList);
		} else {
			return "failure";
		}
	}
	
	public boolean checkWishList( int bookId, int userId) {
		return userWishListService.checkWishList(userId,bookId);		
	}

	private BookDetail getBookDetail(int bookId) {
		return userWishListService.getBookDetail(bookId);
	}
	
	@Path("/getAllWishListByUserId")
	@GET
	@Produces("application/json")
	public List<UserWishList> getAllWishListByUserId(@QueryParam("userId") int userId) {
		return userWishListService.getAllWishListByUserId(userId);
	}
	
	@Path("/deleteSelectedWishList")
	@DELETE
	public String deleteSelectedWishList(@QueryParam("wishListId") int wishListId) {
		
		return userWishListService.deleteSelectedWishList(wishListId);
		
	}
	
}




			
		
	

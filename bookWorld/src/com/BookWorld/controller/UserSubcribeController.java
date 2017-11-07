package com.BookWorld.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.BookWorld.model.BookDetail;
import com.BookWorld.model.UserSubscribe;
import com.BookWorld.model.UserWishList;
import com.BookWorld.service.UserSubscribeService;
import com.BookWorld.service.UserSubscribeServiceImpl;


@Path("/subscribe")
public class UserSubcribeController {
	
	UserSubscribeService userSubscribeService =  new UserSubscribeServiceImpl();	
	
	@Path("/addToSubscribe")
	@POST
	public String addToSubscribeList(@QueryParam("bookId") int bookId,
								     @QueryParam("userId")int userId) {
		
		UserSubscribe userSubscribe = new UserSubscribe();
	    BookDetail bookDetail = new BookDetail();
	    bookDetail = getBookDetail(bookId);
		userSubscribe.setBookDetail(bookDetail);
		userSubscribe.setUserId(userId);
		
		return userSubscribeService.addToSubscribeList(userSubscribe);
		
	}

	@Path("/checkForSubscription")
	@GET
	public UserSubscribe checkForSubscription(@QueryParam("bookId") int bookId ,
									          @QueryParam("userId") int userId) {
										
		return userSubscribeService.checkForSubscription(bookId, userId);
	}
	
	@Path("/getAllSubscribedListByUserId")
	@GET
	public List<UserSubscribe> getAllSubscribedListByUserId(@QueryParam("userId") int userId) {
										
		return userSubscribeService.getAllSubscribedListByUserId(userId);
	}
	
	private BookDetail getBookDetail(int bookId) {
			return userSubscribeService.getBookDetail(bookId);
	}
	
		
}

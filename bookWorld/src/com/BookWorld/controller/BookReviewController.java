package com.BookWorld.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.BookWorld.model.BookReview;
import com.BookWorld.service.BookReviewService;
import com.BookWorld.service.BookReviewServiceImpl;

@Path("/ratingandreview")
public class BookReviewController {
	
	BookReviewService bookReviewService = new BookReviewServiceImpl();
	
	@Path("/addRatingAndReview")
	@POST
	public String addRatingAndReview(BookReview bookReview) {
		return bookReviewService.addRatingAndReview(bookReview);
	}
	
	@Path("/getAllReviews")
	@GET
	public List<BookReview> bookReview(@QueryParam("bookId") int bookid){
		return bookReviewService.getAllReviews(bookid);
		
	}
	
	
}

package com.BookWorld.service;

import java.util.List;

import com.BookWorld.dao.BookReviewDao;
import com.BookWorld.dao.BookReviewDaoImpl;
import com.BookWorld.model.BookReview;

public class BookReviewServiceImpl implements BookReviewService{

	BookReviewDao bookreviewDao = new BookReviewDaoImpl();
	
	@Override
	public String addRatingAndReview(BookReview bookReview) {
		
		return bookreviewDao.addRatingAndReview(bookReview);
	}

	@Override
	public List<BookReview> getAllReviews(int bookId) {
		
		return bookreviewDao.getAllReviews(bookId);
	}

}

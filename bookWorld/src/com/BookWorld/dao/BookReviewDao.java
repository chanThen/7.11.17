package com.BookWorld.dao;

import java.util.List;

import com.BookWorld.model.BookReview;

public interface BookReviewDao {

	String addRatingAndReview(BookReview bookReview);

	List<BookReview> getAllReviews(int bookId);

}

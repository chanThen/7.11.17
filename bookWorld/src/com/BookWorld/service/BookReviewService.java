package com.BookWorld.service;

import java.util.List;

import com.BookWorld.model.BookReview;

public interface BookReviewService {

	String addRatingAndReview(BookReview bookReview);

	List<BookReview> getAllReviews(int bookId);

}

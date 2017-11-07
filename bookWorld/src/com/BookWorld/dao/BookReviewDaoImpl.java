package com.BookWorld.dao;

import java.util.List;

import com.BookWorld.model.BookReview;
import com.BookWorld.util.HibernateUtil;

public class BookReviewDaoImpl implements BookReviewDao{

	HibernateUtil hibernateUtil =  new HibernateUtil();
	
	@Override
	public String addRatingAndReview(BookReview bookReview) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(bookReview);
		hibernateUtil.closeCurrentSessionwithTransaction();
		return "Success";
		
	}

	@Override
	public List<BookReview> getAllReviews(int bookId) {
		
		hibernateUtil.openCurrentSession();
		List<BookReview> bookReview =(List<BookReview>) hibernateUtil.getCurrentSession().createQuery("from BookReview where bookId="+bookId+"").list();
		hibernateUtil.closeCurrentSession();
		
		return bookReview;
		
	}

}

package com.BookWorld.dao;

import java.util.List;

import com.BookWorld.model.BookDetail;
import com.BookWorld.util.HibernateUtil;

public class BookDetailDaoImpl implements BookDetailDao {

	HibernateUtil hibernateUtil = new HibernateUtil();
	@Override
	public List<BookDetail> getAllBookDetails() {
		
		hibernateUtil.openCurrentSession();
		
		List<BookDetail> bookDetails = (List<BookDetail>) hibernateUtil.getCurrentSession().createQuery("from BookDetail").list();
		
		hibernateUtil.closeCurrentSession();
		
		return bookDetails;
	}
	@Override
	public BookDetail  getBookDetailById(int bookId) {
		try {
		hibernateUtil.openCurrentSession();
		BookDetail bookDetail = (BookDetail) hibernateUtil.getCurrentSession().createQuery("from BookDetail where bookId="+bookId+"").uniqueResult();
		hibernateUtil.closeCurrentSession();
		return bookDetail;}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

}

package com.BookWorld.service;

import java.util.List;

import com.BookWorld.dao.BookDetailDao;
import com.BookWorld.dao.BookDetailDaoImpl;
import com.BookWorld.model.BookDetail;

public class BookDetailServiceImpl implements BookDetailService{

	BookDetailDao bookDetailDao = new BookDetailDaoImpl();
	@Override
	public List<BookDetail> getAllBookDetails() {
		
		return bookDetailDao.getAllBookDetails();
	}
	@Override
	public BookDetail getBookDetailById(int bookid) {
		System.out.println("InService");
		return bookDetailDao.getBookDetailById(bookid);
	}

}

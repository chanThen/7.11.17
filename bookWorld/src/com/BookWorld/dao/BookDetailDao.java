package com.BookWorld.dao;

import java.util.List;

import com.BookWorld.model.BookDetail;

public interface BookDetailDao {

	
	public List<BookDetail> getAllBookDetails();

	public BookDetail getBookDetailById(int bookId);
}

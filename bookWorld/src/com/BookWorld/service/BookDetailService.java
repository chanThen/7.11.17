package com.BookWorld.service;

import java.util.List;

import com.BookWorld.model.BookDetail;

public interface BookDetailService {

	public List<BookDetail> getAllBookDetails();

	public BookDetail getBookDetailById(int bookid);
}

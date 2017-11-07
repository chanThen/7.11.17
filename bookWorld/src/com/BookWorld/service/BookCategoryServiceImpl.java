package com.BookWorld.service;

import java.util.List;

import com.BookWorld.dao.BookCategoryDao;
import com.BookWorld.dao.BookCategoryDaoImpl;
import com.BookWorld.model.BookCategory;

public class BookCategoryServiceImpl implements BookCategoryService{

	BookCategoryDao bookCategoryDao = new BookCategoryDaoImpl();
	@Override
	public List<BookCategory> getAllCategories() {
		
		return bookCategoryDao.getAllCategories();
	}

}

package com.BookWorld.dao;

import java.util.List;

import com.BookWorld.model.BookCategory;
import com.BookWorld.util.HibernateUtil;

public class BookCategoryDaoImpl implements BookCategoryDao{

	HibernateUtil hibernateUtil = new HibernateUtil();
	@Override
	public List<BookCategory> getAllCategories() {
		
		hibernateUtil.openCurrentSession();
		
		List<BookCategory> categoryDetail =(List<BookCategory>) hibernateUtil.getCurrentSession().createQuery("from BookCategory").list();
		
		hibernateUtil.closeCurrentSession();
		
		return categoryDetail;
	}

}

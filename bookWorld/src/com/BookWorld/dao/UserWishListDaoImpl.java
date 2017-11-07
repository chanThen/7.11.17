package com.BookWorld.dao;

import java.util.List;

import com.BookWorld.model.BookCategory;
import com.BookWorld.model.BookDetail;
import com.BookWorld.model.UserWishList;
import com.BookWorld.util.HibernateUtil;

public class UserWishListDaoImpl implements UserWishListDao {

	HibernateUtil hibernateUtil =  new HibernateUtil();
	
	@Override
	public String addToWishList(UserWishList userwishList) {

		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(userwishList);
		hibernateUtil.closeCurrentSessionwithTransaction();
		return "Success";

	}

	@Override
	public boolean checkWishList(int userId,int bookId) {
	
		boolean isBookExistInWishList = false;
		hibernateUtil.openCurrentSessionwithTransaction();
		UserWishList userFavouriteList = (UserWishList) hibernateUtil.getCurrentSession().createQuery("from UserWishList where userId='"+userId+"' and bookId='"+bookId+"'").uniqueResult();
		hibernateUtil.closeCurrentSessionwithTransaction();
		if(userFavouriteList!= null) {
			isBookExistInWishList = true;
		}
		return isBookExistInWishList;
	
	}

	@Override
	public BookDetail getBookDetail(int bookId) {
	
		hibernateUtil.openCurrentSessionwithTransaction();
		BookDetail bookDetail = (BookDetail) hibernateUtil.getCurrentSession().createQuery("from BookDetail where bookId='"+bookId+"'").uniqueResult();
		hibernateUtil.closeCurrentSessionwithTransaction();
		return bookDetail;
	}

	@Override
	public List<UserWishList> getAllWishListByUserId(int userId) {
		
		hibernateUtil.openCurrentSessionwithTransaction();
		List<UserWishList>  userWishList = (List<UserWishList>) hibernateUtil.getCurrentSession().createQuery("from UserWishList where userId='"+userId+"'").list();
		hibernateUtil.closeCurrentSessionwithTransaction();
		return  userWishList;
	}

	@Override
	public String deleteSelectedWishList(int wishListId) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().createQuery("delete from UserWishList where wishListId='"+wishListId+"'").executeUpdate();
		hibernateUtil.closeCurrentSessionwithTransaction();
		return "Success";
		
	}
	
}

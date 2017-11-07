package com.BookWorld.dao;

import java.util.List;

import com.BookWorld.model.BookDetail;
import com.BookWorld.model.UserSubscribe;
import com.BookWorld.model.UserWishList;
import com.BookWorld.util.HibernateUtil;

public class UserSubscribeDaoImpl implements UserSubscribeDao {
	
	HibernateUtil hibernateUtil =  new HibernateUtil();
	
	@Override
	public String addToSubscribeList(UserSubscribe userSubscribe) {
		
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(userSubscribe);
		hibernateUtil.closeCurrentSessionwithTransaction();
		return "Success";
	}

	@Override
	public UserSubscribe checkForSubscription(int bookId, int userId) {
		
		hibernateUtil.openCurrentSessionwithTransaction();
		UserSubscribe userSubscribe = (UserSubscribe) hibernateUtil.getCurrentSession().createQuery("from UserSubscribe where bookId='"+bookId+"' and userId = '"+userId+"'").uniqueResult();
		hibernateUtil.closeCurrentSessionwithTransaction();
		return userSubscribe;
	}

	@Override
	public BookDetail getBookDetail(int bookId) {
		hibernateUtil.openCurrentSessionwithTransaction();
		BookDetail bookDetail = (BookDetail) hibernateUtil.getCurrentSession().createQuery("from BookDetail where bookId='"+bookId+"'").uniqueResult();
		hibernateUtil.closeCurrentSessionwithTransaction();
		return bookDetail;
	}

	@Override
	public List<UserSubscribe> getAllSubscribedListByUserId(int userId) {
		hibernateUtil.openCurrentSessionwithTransaction();
		List<UserSubscribe>  userSubscribe = (List<UserSubscribe>) hibernateUtil.getCurrentSession().createQuery("from UserSubscribe where userId='"+userId+"'").list();
		hibernateUtil.closeCurrentSessionwithTransaction();
		return  userSubscribe;
	}
}

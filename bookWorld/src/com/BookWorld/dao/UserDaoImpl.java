package com.BookWorld.dao;

import com.BookWorld.model.User;
import com.BookWorld.util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	HibernateUtil hibernateUtil =  new HibernateUtil();
	
	@Override
	public User findUserByEmail(String email,String pwd) {
		
		hibernateUtil.openCurrentSession();//and password= '"+pwd+"'
		
		User user =(User)hibernateUtil.getCurrentSession().createQuery("from User where email = '"+email+"' and password= '"+pwd+"' and isActive=1").uniqueResult();
		
		hibernateUtil.closeCurrentSession();
		return user;
	}

	@Override
	public String addUser(User user) {
		hibernateUtil.openCurrentSessionwithTransaction();
		Integer id = (Integer)hibernateUtil.getCurrentSession().save(user);
		hibernateUtil.closeCurrentSessionwithTransaction();
		return "Success";
		
	}
	
}

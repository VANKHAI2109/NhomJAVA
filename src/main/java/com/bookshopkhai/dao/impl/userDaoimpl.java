package com.bookshopkhai.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookshopkhai.dao.userDao;
import com.bookshopkhai.entity.userentity;
import com.bookshopkhai.model.userInfor;

public class userDaoimpl implements userDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean login(String user, String password) {

		Session session = sessionFactory.getCurrentSession();
		String sql = "Select new " + userInfor.class.getName() + "(a.id, a.name, a.password, a.email)" + " from "
				+ userentity.class.getName()+ " a where a.name ='"+user+"' and a.password='"+password+"'";
		//String hql = "select * from demo.user E WHERE E.name = '"+ user+"' and E.password = '"+ password +"'";
		Query<?> query = session.createQuery(sql);
		//query.setParameter("user", user);
		//query.setParameter("mk", password);		
		if (query.list().size() >= 1)
			return true;

		return false;
	}

}

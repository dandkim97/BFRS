package com.revature.data.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Login;
import com.revature.data.LoginDao;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class LoginHibernate implements LoginDao{
	
	@Autowired
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public Integer addLogin(Login l) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(l);
			t.commit();
		} catch (HibernateException e) {
			t.rollback();
			LogUtil.logException(e, LoginHibernate.class);
		} finally {
			s.close();
		}
		return i;
	}

	@Override
	public Login getLogin(String username, String pswrd) {
		Session s = hu.getSession();
		String query = "from Login l where l.username=:username and "
				+ "l.pswrd=:password";
		Query<Login> q = s.createQuery(query, Login.class);
		q.setParameter("username", username);
		q.setParameter("password", pswrd);
		Login l = q.uniqueResult();
		s.close();
		return l;
  }

	@Override
	public Login getLogin(Login l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login getLoginById(Login l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLogin(Login l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLogin(Login l) {
		// TODO Auto-generated method stub
	}
}

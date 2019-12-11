package com.revature.data.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Login;
import com.revature.data.LoginDAO;
import com.revature.utils.HibernateUtil;

@Component
public class LoginHibernate implements LoginDAO{
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public Login getLogin(String username, String password) {
		Session s = hu.getSession();
		String query = "from Login l where l.username=:username and "
				+ "l.pswrd=:password";
		Query<Login> q = s.createQuery(query, Login.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		Login l = q.uniqueResult();
		s.close();
		return l;
	}

}

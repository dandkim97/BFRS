package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Logintrip;
import com.revature.data.LogintripDao;
import com.revature.utils.HibernateUtil;

@Component
public class LogintripHibernate implements LogintripDao {

	@Autowired
	private HibernateUtil hu;
	
	@Override
	public Set<Logintrip> getLogintrips() {
		Session s = hu.getSession();
		String query = "from Logintrip";
		Query<Logintrip> q = s.createQuery(query, Logintrip.class);
		List<Logintrip> logintrips = q.list();
		s.close();
		return new HashSet<Logintrip>(logintrips);
	}

}

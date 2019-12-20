package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.revature.beans.Trip;
import com.revature.data.TripDao;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class TripHibernate implements TripDao {

	@Autowired
	private HibernateUtil hu;

	@Override
	public Trip getTrip(int i) {
		Session s = hu.getSession();
		Trip t = s.get(Trip.class, i);
		s.close();
		return t;
	}
	
	@Override
	public Set<Trip> getTrips() {
		Session s = hu.getSession();
		String query = "from Trip";
		Query<Trip> q = s.createQuery(query, Trip.class);
		List<Trip> trips = q.list();
		s.close();
		return new HashSet<Trip>(trips);
	}
	
	@Override
	public Integer addTrip(Trip t) {
		
		Session s = hu.getSession();
		Transaction tx = null;
		Integer i = 0;
		try {
			tx = s.beginTransaction();
			i = (Integer) s.save(t);
			tx.commit();
		} catch(Exception e) {
			if(tx != null)
				tx.rollback();
			LogUtil.logException(e, TripHibernate.class);
			//e.printStackTrace();
		} finally {
			s.close();
		}
		return i;
	}

}

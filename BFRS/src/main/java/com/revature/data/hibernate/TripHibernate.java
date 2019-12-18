package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.revature.beans.Form;
import com.revature.beans.Plane;
import com.revature.beans.Trip;
import com.revature.beans.TripView;
import com.revature.data.TripDao;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class TripHibernate implements TripDao {
	private Logger log = Logger.getLogger(TripHibernate.class);

	@Autowired
	private HibernateUtil hu= HibernateUtil.getInstance();

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
	public Set<TripView> getTripsByCustomerId(Integer id) {
		Session s = hu.getSession();
		String query = "from TripView t where t.userId = :id";
		Query<TripView> tv = s.createQuery(query, TripView.class);
		tv.setParameter("id",  id);
		List<TripView> tripViews = tv.list();
		s.close();
		return new HashSet<TripView>(tripViews);
	}

	@Override
	public Integer addCustomerTripHistory(TripView tv) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(tv);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, TripHibernate.class);
		} finally {
			s.close();
		}
		return tv.getId();
	}


}

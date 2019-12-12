package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Trip;
import com.revature.data.TripDao;
import com.revature.utils.HibernateUtil;

@Component
public class TripHibernate implements TripDao{
	
	@Autowired
	private HibernateUtil hu;
	
	
	@Override
	public Set<Trip> getTrips() {
		Session s = hu.getSession();
		String query = "from Trip";
		Query<Trip> q = s.createQuery(query, Trip.class);
		List<Trip> trips = q.list();
		s.close();
		return new HashSet<Trip>(trips);
	}
	 

}

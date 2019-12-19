package com.revature.data.hibernate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		List<Trip> trips = q.getResultList();
		s.close();
		return new HashSet<Trip>(trips);
	}

	@Override
	public Set<TripView> getTripsByCustomerId(Integer id) {
		Session s = hu.getSession();
		String query = "from TripView t where t.userId = :id";
		Query<TripView> tv = s.createQuery(query, TripView.class);
		tv.setParameter("id",  id);
		List<TripView> tripViews = tv.getResultList();
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

//	@Override
//	public List<TripView> getAllHistoryTrips() {
//		Session s = hu.getSession();
//		String query = "from TripView order by userName ASC";
//		Query<TripView> q = s.createQuery(query, TripView.class);
//		List<TripView> tripViews = q.getResultList();
//		s.close();
//		return tripViews;
//	}

	@Override
	public List<TripView> getAllHistoryTrips() {
		Session s = hu.getSession();
		String nativeSQL = "select l.id as lid, l.username as us, "
				+ "p.model as md, t.trip_from as tf, t.trip_to as tt, t.departure as dp, "
				+ "t.arrival as av, f.num_seats as ns, f.is_round as ir, lt.trip_cost as tc "
				+ "from forms f, login_trip lt, trip t, login l, plane p "
				+ "where lt.login_id = f.login_id and f.trip_id = lt.trip_id "
				+ "and t.id = f.trip_id and l.id = lt.login_id and t.plane_id = p.id "
				+ "and lt.login_id >= :uid order by us ASC";
			Query query = s.createNativeQuery(nativeSQL);
			query.setParameter("uid",  1);  //get all users since condition is > =
			List<Object[]> tvObj = query.list();
//			System.out.println(tripViews.toString());
			List<TripView> tm = new ArrayList<TripView>();
			 for (Object[] a : tvObj) {
				 TripView t = new TripView();
//				 System.out.println(" a0 "+a[0]+" a1 "+a[1]
//						 + " a2 "+a[2] + " a3 "+a[3]
//						 + " a4 "+a[4] + " a5 "+a[5]		 
//						+ " a6 "+a[6] + " a7 "+a[7]
//						+ " a8 "+a[8] + " a9 "+a[9] 
//						 );
				  t.setUserId(((BigDecimal) a[0]).intValue()); 
//				  System.out.println("user id is "+t.getUserId());
				  t.setUserName((String) a[1]); 
//				  System.out.println("user name is "+t.getUserName());
				  
				  t.setModel((String) a[2]); //model
				  t.setTripFrom((String) a[3]); //tripFrom
				  t.setTripTo((String) a[4]); //tripTo
				  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				  String nd  = dateFormat.format(a[5]);
//				  System.out.println(nd);
				  t.setDeparture(nd);
//				  System.out.println("departure is  "+t.getDeparture());
				  String na = dateFormat.format(a[6]);
				  t.setArrival(na);
				  t.setNumSeats(((BigDecimal) a[7]).intValue());
				  t.setIsRound(((BigDecimal) a[8]).intValue());
				  t.setTripCost(((BigDecimal) a[9]).intValue());
				  
				  tm.add(t); 
				  System.out.println(tm);				  
				 }
			
			
			s.close();
			return tm;
		}
	
	
	
	
}

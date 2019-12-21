package com.revature.data.hibernate;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Form;
import com.revature.beans.Trip;
import com.revature.beans.TripView;
import com.revature.data.TripDao;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class TripHibernate implements TripDao {

	@Autowired
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public int addTrip(Trip t) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(t);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, TripHibernate.class);
		} finally {
			s.close();
		}
		return t.getId();
	}
	
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
	public Trip updateTrip(Trip t) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(t);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		return t;
	}
	
	@Override
	public List<TripView> getAllHistoryTrips() {
		Session s = hu.getSession();
		String nativeSQL = "select distinct l.id as lid, l.username as us, "
				+ "p.model as md, t.trip_from as tf, t.trip_to as tt, t.departure as dp, "
				+ "t.arrival as av, f.is_round as ir, lt.trip_cost as tc, t.id as ti "
				+ "from forms f, login_trip lt, trip t, login l, plane p "
				+ "where lt.login_id = f.login_id and f.trip_id = lt.trip_id "
				+ "and t.id = f.trip_id and l.id = lt.login_id and t.plane_id = p.id "
				+ "and lt.login_id >= :uid order by av ASC";
			Query query = s.createNativeQuery(nativeSQL);
			query.setParameter("uid",  1);  //get all users since condition is > =
			List<Object[]> tvObj = query.list();
			List<TripView> tm = new ArrayList<TripView>();
			 for (Object[] a : tvObj) {
				 TripView t = new TripView();
				  t.setUserId(((BigDecimal) a[0]).intValue()); 
				  t.setUserName((String) a[1]); 
				  t.setModel((String) a[2]); //model
				  t.setTripFrom((String) a[3]); //tripFrom
				  t.setTripTo((String) a[4]); //tripTo
				  t.setDeparture((String) a[5]);
				  t.setArrival((String) a[6]);
				  t.setNumSeats((int)(Math.random()*3) + 1);
				  t.setIsRound(((BigDecimal) a[7]).intValue());
				  t.setTripCost(((BigDecimal) a[8]).intValue());
				  t.setTripId(((BigDecimal) a[9]).intValue());
				  
				  tm.add(t); 
				  System.out.println(tm);				  
        }
			
			s.close();
			return tm;
		}

	@Override
	public void addTripSeats(Trip t, Integer num) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			String nativeSQL = "update Trip set seats_taken = seats_taken+:num "
					+ "where id = :id";
			NativeQuery<Trip> q = s.createNativeQuery(nativeSQL, Trip.class);
			q.setParameter("num", num);
			q.setParameter("id", t.getId());
			q.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, TripHibernate.class);
		} finally {
			s.close();
		}
	}
}

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
	public Trip updateTrip(Trip t) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(t);
			tx.commit();
		} catch(Exception e) {
			if(tx != null)
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
				+ "t.arrival as av, f.num_seats as ns, f.is_round as ir, lt.trip_cost as tc "
				+ "from forms f, login_trip lt, trip t, login l, plane p "
				+ "where lt.login_id = f.login_id "
				+ "and lt.trip_id = f.trip_id "
				+ "and l.id = lt.login_id "
				+ "and t.id = lt.trip_id "			
				+ "and t.plane_id = p.id "
				+ "and lt.login_id >= :uid";
		NativeQuery<TripView> q = s.createNativeQuery(nativeSQL, "GetTripHistoryResults");
		q.setParameter("uid",  1);
//		System.out.println(q.list().toString());	
		List<TripView> tripViews = q.list();

		s.close();
		return tripViews;
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

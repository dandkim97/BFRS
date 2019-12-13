package com.revature.hibernate;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.revature.beans.Plane;
import com.revature.beans.Trip;
import com.revature.data.PlaneDao;
import com.revature.utils.HibernateUtil;

@Component
public class PlaneHibernate implements PlaneDao {
	private static Logger log = Logger.getLogger(PlaneHibernate.class);
	
	@Autowired
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public Plane getMaxSeats(Integer id) {
//		System.out.println("in planeHibernate id is "+id);
		Session s = hu.getSession();
		Plane p = s.get(Plane.class, id);
		s.close();
		return p;
	}

	@Override
	public Trip getSeatsTaken(Integer id) { //need dummy data to test
		Session s = hu.getSession();
		Trip t = s.get(Trip.class, id);
		s.close();
		return t;
	}

	@Override
	public Plane getMxSeat(Integer id) {  //same as getMaxSeat - just using query
		Session s = hu.getSession();
		String query = "from Plane p where p.id = :id";
		Query<Plane> qp = s.createQuery(query, Plane.class);
		qp.setParameter("id",  id);
		Plane p = qp.uniqueResult();
		s.close();
		return p;
	}

	@Override
	public List<Trip> getAllTripsAvail() {
		
		Session s = hu.getSession();
//		String query = "from Plane";
//		Query<Trip> qt = s.createQuery(query, Trip.class);
	//	qt.setParameter("code", "7277");
	//	List<Trip> t;
//		String nativeSQL = "select * from Trip where plane_id = Plane.id and Plane.seats > seats_taken";
		System.out.println("in PlaneHibernate preparing query list for available flights");
		String nativeSQL = "select t.* from trip t, plane p where plane_id = p.id and seats_taken < p.seats";
		NativeQuery<Trip> q = s.createNativeQuery(nativeSQL, Trip.class);
		List<Trip> tripList = q.getResultList();		
		
//		List<Trip> tripList = qt.getResultList();
		log.trace(tripList);
		s.close();		
		return tripList;
	}

}

package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
	public Plane getPlane(int i) {
		Session s = hu.getSession();
		Plane p = s.get(Plane.class, i);
		s.close();
		return p;
	}
	
	@Override
	public Set<Plane> getPlanes() {
		Session s = hu.getSession();
		String query = "FROM Plane";
		Query<Plane> q = s.createQuery(query, Plane.class);
		List<Plane> planeList = q.getResultList();
		Set<Plane> planeSet = new HashSet<Plane>();
		planeSet.addAll(planeList);
		s.close();
		return planeSet;
	}
	
	@Override
	public Plane getMaxSeats(Integer id) {
		Session s = hu.getSession();
		Plane p = s.get(Plane.class, id);
		s.close();
		return p;
	}

	@Override
	public Trip getSeatsTaken(Integer id) { 
		Session s = hu.getSession();
		Trip t = s.get(Trip.class, id);
		s.close();
		return t;
	}

	@Override
	public Plane getMxSeat(Integer id) {  
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
		System.out.println("in PlaneHibernate preparing query list for available flights");
		String nativeSQL = "select t.* from trip t, plane p where plane_id = p.id and seats_taken < p.seats order by departure";
		NativeQuery<Trip> q = s.createNativeQuery(nativeSQL, Trip.class);
		List<Trip> tripList = q.getResultList();		
		log.trace(tripList);
		s.close();		
		return tripList;
	}

	@Override
	public void updatePlane(Plane p) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(p);
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			s.close();
		}
		
	}

	@Override
	public Plane getPlane(String model) {
		Session s = hu.getSession();
		String query = "from Plane p where p.model=:model";
		Query<Plane> qp = s.createQuery(query, Plane.class);
		qp.setParameter("model", model);
		Plane p = qp.uniqueResult();
		s.close();
		return p;
		
	}

}
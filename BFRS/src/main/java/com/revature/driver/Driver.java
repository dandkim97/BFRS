package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Plane;
import com.revature.beans.Trip;
import com.revature.services.PlaneService;
import com.revature.utils.HibernateUtil;



public class Driver {
	private static HibernateUtil hu = HibernateUtil.getInstance();
	private static Logger log = Logger.getLogger(Driver.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		PlaneDao hb = new PlaneHibernate();
//		Plane planeSeats = hb.getMaxSeats(5);
//		Integer seats = planeSeats.getSeats();
//		System.out.println("max seats are: "+seats);
		
		
//		Plane p1 = secondRetrieval(5);
//		System.out.println("seats are "+p1.getSeats());
		
		// test driver to insert data into the database
	//	insertion(); 

//		hu.getSessionFactory().close();
		
//		PlaneService ps = new PlaneService();
//		Integer ms = ps.getMaxiumSeats(5).getSeats();
//		System.out.println("maximum seats on this flight is "+ms);
		
//		Plane pp = getMxSeat(6);
//		Integer msa = pp.getSeats();
//		System.out.println("maximum seats on this flight is "+msa);
		
		PlaneService ps = new PlaneService();
//		Integer seatAvailability = ps.getSeatsAvailable(5);
//		System.out.println("seats available to book is " +seatAvailability);
		
		
		//test for flight capacity left
		Integer flightNum = 5;		
		System.out.println("prepareing to get seats available");
		Integer seatsAvail = ps.getSeatsAvailable(flightNum);
		System.out.println("maxium seatsAvail for "+flightNum + " is "+seatsAvail);
		
		//test for flights to show with capacity
		List<Trip> flights = new ArrayList<>();
		flights = ps.findAllAvailTrips();
		System.out.println("flights "+flights.toString());
		
		
	}
	
//	public static Integer getSeatsAvailable(Integer id) {
//		PlaneService maxSeats = new PlaneService();
//		Integer tempSeatsTaken = 150;  //assume this value comes from TripDao table
//		Plane ps = new Plane();
//		ps = maxSeats.getMaxiumSeats(id);
//		Integer seatsAvail = ps.getSeats() - tempSeatsTaken;
//	return seatsAvail;  //maximum number of seats that can be booked
//	}
//	
	public static Plane getMxSeat(Integer id) {
		Session s = hu.getSession();
		String query = "from Plane p where p.id = :id";
		Query<Plane> qp = s.createQuery(query, Plane.class);
		qp.setParameter("id",  id);
		Plane p = qp.uniqueResult();
		s.close();
		return p;
	}

	
	public static Plane secondRetrieval(int i) {
		Session s = hu.getSession();
		Plane pl = s.get(Plane.class, i);
		log.trace(pl);
		s.close();
		return pl;
	}
	
	
	
	
	public static void insertion() {
		Plane plane = new Plane();
		plane.setModel("American Airlines 101");
		plane.setSeats(260); 
		plane.setAvg_rating(4);
			
		
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(plane);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			log.error(e.getMessage());
		} finally {
			s.close();
		}
		
		log.trace(plane.getId());

	}

}

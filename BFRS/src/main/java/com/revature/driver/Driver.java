package com.revature.driver;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Plane;
import com.revature.utils.HibernateUtil;



public class Driver {
	private static HibernateUtil hu = HibernateUtil.getInstance();
	private static Logger log = Logger.getLogger(Driver.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// test driver to insert data into the database
		insertion(); 

		hu.getSessionFactory().close();
		
	}
	
	public static void insertion() {
		Plane plane = new Plane();
		plane.setModel("United Airlines 101");
		plane.setSeats(250); 
		plane.setAvg_rating(3);
			
		
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

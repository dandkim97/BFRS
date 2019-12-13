package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Plane;
import com.revature.beans.Trip;
import com.revature.data.PlaneDao;
import com.revature.hibernate.PlaneHibernate;

@Service
public class PlaneService {
	
	@Autowired
	private PlaneDao pd = new PlaneHibernate();	
	
	public Plane getMaxiumSeats(Integer id) {
//		System.out.println("in getMax seats id is "+id);
		return pd.getMaxSeats(id);    //returns the plane object then use getSeats to get max seats
		
	}
	
	public Integer getSeatsAvailable(Integer id) {
		PlaneService maxSeats = new PlaneService();
		Integer tempSeatsTaken = 150;  //assume this value comes from TripDao table
		Plane ps = new Plane();
//		System.out.println("in getSeatsAvailable id is "+id);
		ps = maxSeats.getMaxiumSeats(id);
		Integer seatsAvail = ps.getSeats() - tempSeatsTaken;
	return seatsAvail;  //maximum number of seats that can be booked
	}
	
	public List<Trip> findAllAvailTrips(){
		List<Trip> flightList = new ArrayList<>();
		flightList = pd.getAllTripsAvail();
		return flightList;
	}

}

package com.revature.services.hibernate;

import java.util.Set;

import com.revature.beans.Trip;
import com.revature.data.TripDao;
import com.revature.data.hibernate.TripHibernate;
import com.revature.services.TripService;

public class TripServiceHibernate implements TripService{
	private static TripDao td = new TripHibernate();

	@Override
	public Trip getTripById(int id) {
		return td.getTrip(id);
	}

	@Override
	public Set<Trip> getTrips() {
		return td.getTrips();
	}
	
}
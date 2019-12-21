package com.revature.services.hibernate;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Trip;
import com.revature.beans.TripView;
import com.revature.data.TripDao;
import com.revature.data.hibernate.TripHibernate;
import com.revature.services.TripService;

@Service
public class TripServiceHibernate implements TripService{
	private static TripDao td = new TripHibernate();

	@Override
	public void addTrip(Trip t) {
		td.addTrip(t);
	}
	
	@Override
	public Trip getTripById(int id) {
		return td.getTrip(id);
	}

	@Override
	public Set<Trip> getTrips() {
		return td.getTrips();
	}

	@Override
	public List<TripView> getAllTripsHistory() {
		return td.getAllHistoryTrips();	
	}

	@Override
	public Trip updateTrip(Trip t) {
		return td.updateTrip(t);
	}	

}

package com.revature.services;

import java.util.List;
import java.util.Set;

import com.revature.beans.Trip;
import com.revature.beans.TripView;

public interface TripService {
	public void addTrip(Trip t);
	public Trip getTripById(int id);
	public Set<Trip> getTrips();
	public List<TripView> getAllTripsHistory();
	public Trip updateTrip(Trip t);
}

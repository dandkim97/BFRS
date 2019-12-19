package com.revature.data;

import java.util.Set;

import com.revature.beans.Trip;

public interface TripDao {
	public Trip getTrip(int i);
	public Set<Trip> getTrips();
	public Trip updateTrip(Trip t);
}

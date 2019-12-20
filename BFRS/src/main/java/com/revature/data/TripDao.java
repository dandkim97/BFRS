package com.revature.data;

import java.util.List;
import java.util.Set;
import com.revature.beans.Trip;
import com.revature.beans.TripView;

public interface TripDao {
	
	public int addTrip(Trip t);
	public Trip getTrip(int i);
	public Set<Trip> getTrips();
	public Trip updateTrip(Trip t);
	public List<TripView> getAllHistoryTrips();
}

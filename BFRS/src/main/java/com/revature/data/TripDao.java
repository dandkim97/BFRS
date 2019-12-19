package com.revature.data;

import java.util.List;
import java.util.Set;


import com.revature.beans.Trip;
import com.revature.beans.TripView;

public interface TripDao {
	public Trip getTrip(int i);
	public Set<Trip> getTrips();
	public Set<TripView> getTripsByCustomerId(Integer id);
	public Integer addCustomerTripHistory(TripView tv);
	public List<TripView> getAllHistoryTrips();
}

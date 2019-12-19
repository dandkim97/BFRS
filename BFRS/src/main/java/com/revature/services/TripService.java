package com.revature.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Trip;
import com.revature.beans.TripView;

@Service
public interface TripService {
	public Trip getTripById(int id);
	public Set<Trip> getTrips();
	public Set<TripView> getAllTripsByCustomerId(Integer id);
	public Integer addTripHistoryCustomer(TripView tv);
	public List<TripView> getAllTripsHistory();
}

package com.revature.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Trip;

@Service
public interface TripService {
	public Trip getTripById(int id);
	public Set<Trip> getTrips();
}

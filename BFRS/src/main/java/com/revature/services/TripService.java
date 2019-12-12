package com.revature.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Trip;
import com.revature.data.TripDao;

@Service
public class TripService {
	@Autowired
	private TripDao td;

	public Set<Trip> getTrips() {
		return td.getTrips();
	}

}

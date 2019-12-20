package com.revature.services;

import java.util.List;

import com.revature.beans.Plane;
import com.revature.beans.Trip;

public interface PlaneService {
	public Plane getMaxiumSeats(Integer id);
	public Integer getSeatsAvailable(Integer id);
	public List<Trip> findAllAvailTrips();
	public void updatePlane(Plane p);
	public Plane getPlane(String model);
}

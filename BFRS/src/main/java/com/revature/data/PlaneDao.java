package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.Form;
import com.revature.beans.Plane;
import com.revature.beans.Trip;

public interface PlaneDao {
	public Plane getPlane(int i);
	public Set<Plane> getPlanes();
	List<Trip> getAllTripsAvail();
	Plane getMaxSeats(Integer id);  	//from Plane table or object
	Plane getMxSeat(Integer id);  		//using criteria but same as getMaxSeats above
	Trip getSeatsTaken(Integer id);  	//from Trip table or object
	public void updatePlane(Plane p);
}
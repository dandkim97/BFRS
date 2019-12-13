package com.revature.data;

import java.util.List;

import com.revature.beans.Plane;
import com.revature.beans.Trip;

public interface PlaneDao {
	
	Plane getMaxSeats(Integer id);  //from Plane trable or object
//	Integer getFormSeats()
	Plane getMxSeat(Integer id);  //using criteria but same as getMaxSeats above
	
	Trip getSeatsTaken(Integer id);  //from Trip table or object
	
	List<Trip> getAllTripsAvail();
	
	
}

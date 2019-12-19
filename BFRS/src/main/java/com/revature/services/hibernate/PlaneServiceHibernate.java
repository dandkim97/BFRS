package com.revature.services.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Plane;
import com.revature.beans.Trip;
import com.revature.data.PlaneDao;
import com.revature.data.hibernate.PlaneHibernate;
import com.revature.services.PlaneService;

@Service
public class PlaneServiceHibernate implements PlaneService {

	@Autowired
	private PlaneDao pd = new PlaneHibernate();

	@Override
	public Plane getMaxiumSeats(Integer id) {
		return pd.getMaxSeats(id);
	}

	@Override
	public Integer getSeatsAvailable(Integer id) {
		Integer tempSeatsTaken = 150;
		Plane ps = new Plane();
		ps = getMaxiumSeats(id);
		Integer seatsAvail = ps.getSeats() - tempSeatsTaken;
		return seatsAvail;
	}

	@Override
	public List<Trip> findAllAvailTrips() {
		List<Trip> flightList = new ArrayList<>();
		flightList = pd.getAllTripsAvail();
		return flightList;
	}

	@Override
	public void updatePlane(Plane p) {
		pd.updatePlane(p);
		
	}

}

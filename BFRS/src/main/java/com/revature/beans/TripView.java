package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


@Entity
@Table(name = "tripview")
public class TripView {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tripview")
	@SequenceGenerator(name = "tripview", sequenceName = "tripview_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "login_id")
	private Integer userId;
	@Column(name = "trip_from")
	private String tripFrom;
	@Column(name = "trip_to")
	private String tripTo;
	@Column
	private String departure;
	@Column
	private String arrival;
	@Column (name = "num_seats")
	private Integer numSeats;
	@Column(name = "is_round")
	private Integer isRound;
	@Column(name = "trip_cost")
	private Integer tripCost;
	
	
	public TripView() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TripView(Integer id, Integer userId, String tripFrom, String tripTo, String departure, String arrival,
			Integer numSeats, Integer isRound, Integer tripCost) {
		super();
		this.id = id;
		this.userId = userId;
		this.tripFrom = tripFrom;
		this.tripTo = tripTo;
		this.departure = departure;
		this.arrival = arrival;
		this.numSeats = numSeats;
		this.isRound = isRound;
		this.tripCost = tripCost;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	

	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getTripFrom() {
		return tripFrom;
	}


	public void setTripFrom(String tripFrom) {
		this.tripFrom = tripFrom;
	}


	public String getTripTo() {
		return tripTo;
	}


	public void setTripTo(String tripTo) {
		this.tripTo = tripTo;
	}


	public String getDeparture() {
		return departure;
	}


	public void setDeparture(String departure) {
		this.departure = departure;
	}


	public String getArrival() {
		return arrival;
	}


	public void setArrival(String arrival) {
		this.arrival = arrival;
	}


	public Integer getNumSeats() {
		return numSeats;
	}


	public void setNumSeats(Integer numSeats) {
		this.numSeats = numSeats;
	}


	public Integer getIsRound() {
		return isRound;
	}


	public void setIsRound(Integer isRound) {
		this.isRound = isRound;
	}


	public Integer getTripCost() {
		return tripCost;
	}


	public void setTripCost(Integer tripCost) {
		this.tripCost = tripCost;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrival == null) ? 0 : arrival.hashCode());
		result = prime * result + ((departure == null) ? 0 : departure.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isRound == null) ? 0 : isRound.hashCode());
		result = prime * result + ((numSeats == null) ? 0 : numSeats.hashCode());
		result = prime * result + ((tripCost == null) ? 0 : tripCost.hashCode());
		result = prime * result + ((tripFrom == null) ? 0 : tripFrom.hashCode());
		result = prime * result + ((tripTo == null) ? 0 : tripTo.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TripView other = (TripView) obj;
		if (arrival == null) {
			if (other.arrival != null)
				return false;
		} else if (!arrival.equals(other.arrival))
			return false;
		if (departure == null) {
			if (other.departure != null)
				return false;
		} else if (!departure.equals(other.departure))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isRound == null) {
			if (other.isRound != null)
				return false;
		} else if (!isRound.equals(other.isRound))
			return false;
		if (numSeats == null) {
			if (other.numSeats != null)
				return false;
		} else if (!numSeats.equals(other.numSeats))
			return false;
		if (tripCost == null) {
			if (other.tripCost != null)
				return false;
		} else if (!tripCost.equals(other.tripCost))
			return false;
		if (tripFrom == null) {
			if (other.tripFrom != null)
				return false;
		} else if (!tripFrom.equals(other.tripFrom))
			return false;
		if (tripTo == null) {
			if (other.tripTo != null)
				return false;
		} else if (!tripTo.equals(other.tripTo))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "TripView [id=" + id + ", userId=" + userId + ", tripFrom=" + tripFrom + ", tripTo=" + tripTo
				+ ", departure=" + departure + ", arrival=" + arrival + ", numSeats=" + numSeats + ", isRound="
				+ isRound + ", tripCost=" + tripCost + "]";
	}

	
	

}

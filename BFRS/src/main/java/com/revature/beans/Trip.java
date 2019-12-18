package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "trip")
public class Trip {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trip")
	@SequenceGenerator(name = "trip", sequenceName = "trip_seq", allocationSize = 1)
	private Integer id;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "plane_id") // the fk to the entity
	private Plane plane;
	@Column(name = "seats_taken")
	private Integer seatsTaken;
	@Column(name = "trip_from")
	private String tripFrom;
	@Column(name = "trip_to")
	private String tripTo;
	@Column
	private String departure;
	@Column
	private String arrival;
	@Column
	private Double price;

	public Trip() {
		super();
	}

	public Trip(Integer id, Plane plane, Integer seatsTaken, String tripFrom, String tripTo, String departure,
			String arrival, Double price) {
		super();
		this.id = id;
		this.plane = plane;
		this.seatsTaken = seatsTaken;
		this.tripFrom = tripFrom;
		this.tripTo = tripTo;
		this.departure = departure;
		this.arrival = arrival;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public Integer getSeatsTaken() {
		return seatsTaken;
	}

	public void setSeatsTaken(Integer seatsTaken) {
		this.seatsTaken = seatsTaken;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrival == null) ? 0 : arrival.hashCode());
		result = prime * result + ((departure == null) ? 0 : departure.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((plane == null) ? 0 : plane.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((seatsTaken == null) ? 0 : seatsTaken.hashCode());
		result = prime * result + ((tripFrom == null) ? 0 : tripFrom.hashCode());
		result = prime * result + ((tripTo == null) ? 0 : tripTo.hashCode());
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
		Trip other = (Trip) obj;
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
		if (plane == null) {
			if (other.plane != null)
				return false;
		} else if (!plane.equals(other.plane))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (seatsTaken == null) {
			if (other.seatsTaken != null)
				return false;
		} else if (!seatsTaken.equals(other.seatsTaken))
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
		return true;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", plane=" + plane + ", seatsTaken=" + seatsTaken + ", tripFrom=" + tripFrom
				+ ", tripTo=" + tripTo + ", departure=" + departure + ", arrival=" + arrival + ", price=" + price + "]";
	}

}
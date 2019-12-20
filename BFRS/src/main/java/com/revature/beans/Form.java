package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "forms")
public class Form {
	@Id
	@Column
	@SequenceGenerator(name = "form", sequenceName = "form_seq", allocationSize = 1)
	@GeneratedValue(generator = "form", strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "num_seats")
	private Integer numSeats;
	@Column(name = "num_bags")
	private Integer numBags;
	@Column(name = "plane_class")
	private String planeClass;
	@Column(name = "is_round")
	private Integer isRound;
	@Column(name = "trip_id")
	private Integer tripId;
	@Column(name = "login_id")
	private Integer loginId;

	public Form() {
		super();
	}

	public Form(Integer id, Integer numSeats, Integer numBags, String planeClass, Integer isRound, Integer tripId,
			Integer loginId) {
		super();
		this.id = id;
		this.numSeats = numSeats;
		this.numBags = numBags;
		this.planeClass = planeClass;
		this.isRound = isRound;
		this.tripId = tripId;
		this.loginId = loginId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(Integer numSeats) {
		this.numSeats = numSeats;
	}

	public Integer getNumBags() {
		return numBags;
	}

	public void setNumBags(Integer numBags) {
		this.numBags = numBags;
	}

	public String getPlaneClass() {
		return planeClass;
	}

	public void setPlaneClass(String planeClass) {
		this.planeClass = planeClass;
	}

	public Integer getIsRound() {
		return isRound;
	}

	public void setIsRound(Integer isRound) {
		this.isRound = isRound;
	}

	public Integer getTripId() {
		return tripId;
	}

	public void setTrip(Integer tripId) {
		this.tripId = tripId;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isRound == null) ? 0 : isRound.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result + ((numBags == null) ? 0 : numBags.hashCode());
		result = prime * result + ((numSeats == null) ? 0 : numSeats.hashCode());
		result = prime * result + ((planeClass == null) ? 0 : planeClass.hashCode());
		result = prime * result + ((tripId == null) ? 0 : tripId.hashCode());
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
		Form other = (Form) obj;
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
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (numBags == null) {
			if (other.numBags != null)
				return false;
		} else if (!numBags.equals(other.numBags))
			return false;
		if (numSeats == null) {
			if (other.numSeats != null)
				return false;
		} else if (!numSeats.equals(other.numSeats))
			return false;
		if (planeClass == null) {
			if (other.planeClass != null)
				return false;
		} else if (!planeClass.equals(other.planeClass))
			return false;
		if (tripId == null) {
			if (other.tripId != null)
				return false;
		} else if (!tripId.equals(other.tripId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Form [id=" + id + ", numSeats=" + numSeats + ", numBags=" + numBags + ", planeClass=" + planeClass
				+ ", isRound=" + isRound + ", tripId=" + tripId + ", loginId=" + loginId + "]";
	}

}

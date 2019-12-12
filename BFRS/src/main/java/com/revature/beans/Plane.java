package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Plane {
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="plane")
	@SequenceGenerator(name="plane", sequenceName="plane_seq", allocationSize=1)
	private Integer id;
	private String model;
	private Integer seats;
	@Column(name="avg_rating")
	private Integer avgRating;
	public Plane() {
		super();
	
	}
	public Plane(Integer id, String model, Integer seats, Integer avgRating) {
		super();
		this.id = id;
		this.model = model;
		this.seats = seats;
		this.avgRating = avgRating;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public Integer getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Integer avgRating) {
		this.avgRating = avgRating;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avgRating == null) ? 0 : avgRating.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((seats == null) ? 0 : seats.hashCode());
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
		Plane other = (Plane) obj;
		if (avgRating == null) {
			if (other.avgRating != null)
				return false;
		} else if (!avgRating.equals(other.avgRating))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (seats == null) {
			if (other.seats != null)
				return false;
		} else if (!seats.equals(other.seats))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Plane [id=" + id + ", model=" + model + ", seats=" + seats + ", avgRating=" + avgRating + "]";
	}
	
	
	
}


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
@Table(name = "login_trip")
public class Logintrip {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logintrip")
	@SequenceGenerator(name = "logintrip", sequenceName = "logintrip_seq", allocationSize = 1)
	private Integer id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id") // the fk to the entity
	private Login login;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "trip_id") // the fk to the entity
	private Trip trip;
	
	@Column(name = "trip_cost")
	private Double cost;

	public Logintrip() {
		super();
		// TODO Auto-generated constructor stub
	}

}




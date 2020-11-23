package qlhvt.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "driver_trip")
public class DriverTrip implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "driver_type")
	private Integer driverType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "trip_id", nullable = false)
	private Trip trip;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "driver_id", nullable = false)
	private Driver driver;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDriverType() {
		return driverType;
	}

	public void setDriverType(Integer driverType) {
		this.driverType = driverType;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
}

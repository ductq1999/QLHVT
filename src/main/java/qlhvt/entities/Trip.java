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
@Table(name = "trip")
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "code")
	private String code;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "buses_id", nullable = false)
	private Buses buses;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "driver_primary", nullable = false)
	private Driver driverPrimary;

	@ManyToOne
	@JoinColumn(name = "driver_foreign", nullable = false)
	private Driver driverForeign;

	@Column(name = "guest_number")
	private Integer guestNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Buses getBuses() {
		return buses;
	}

	public void setBuses(Buses buses) {
		this.buses = buses;
	}

	public Driver getDriverPrimary() {
		return driverPrimary;
	}

	public void setDriverPrimary(Driver driverPrimary) {
		this.driverPrimary = driverPrimary;
	}

	public Driver getDriverForeign() {
		return driverForeign;
	}

	public void setDriverForeign(Driver driverForeign) {
		this.driverForeign = driverForeign;
	}

	public Integer getGuestNumber() {
		return guestNumber;
	}

	public void setGuestNumber(Integer guestNumber) {
		this.guestNumber = guestNumber;
	}

	public Integer getFare() {
		return fare;
	}

	public void setFare(Integer fare) {
		this.fare = fare;
	}

	@Column(name = "fare")
	private Integer fare;
}

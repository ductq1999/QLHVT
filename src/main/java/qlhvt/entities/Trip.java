package qlhvt.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "trip")
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	//ma so chuyen xe
	@Column(name = "code")
	private String code;

	@Column(name = "status", nullable = false)
	private Integer status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "buses_id", nullable = false)
	private Buses buses;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "coach_id", nullable = false)
	private Coach coach;

	
	//so khach
	@Column(name = "guest_number")
	private Integer guestNumber;

	
	@Column(name = "date", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	
	//gia ve
	@Column(name = "fare")
	private Integer fare;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

}

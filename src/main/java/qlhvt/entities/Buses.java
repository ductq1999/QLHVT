package qlhvt.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "buses")
public class Buses implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "first", nullable = false)
	private String first;

	@Column(name = "last", nullable = false)
	private String last;
	
	@Column(name = "length", nullable = false)
	private String length;

	@Column(name = "complexity", nullable = false)
	private Integer complexity;
	
	@Column(name = "status", nullable = false)
	private Integer status;
	
//	@OneToMany(mappedBy = "buses", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Trip> trip = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public Integer getComplexity() {
		return complexity;
	}

	public void setComplexity(Integer complexity) {
		this.complexity = complexity;
	}


//	public List<Trip> getTrip() {
//		return trip;
//	}
//
//	public void setTrip(List<Trip> trip) {
//		this.trip = trip;
//	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

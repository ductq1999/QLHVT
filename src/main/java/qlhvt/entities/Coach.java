package qlhvt.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "coach")
public class Coach implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	//bien so 
	@Column(name = "license_plate", nullable = false)
	private String licensePlate;

	//mau xe
	@Column(name = "color", nullable = false)
	private String color;
	
	//hang san xuat
	@Column(name = "manufacturer", nullable = false)
	private String manufacturer;

	//doi xe
	@Column(name = "car_type", nullable = false)
	private String carType;

	//model
	@Column(name = "model", nullable = false)
	private String model;

	//so ghe
	@Column(name = "chair", nullable = false)
	private Integer chair;

	//so nam su dung
	@Column(name = "year_used", nullable = false)
	private Integer yearUsed;
	
	@Column(name = "status", nullable = false)
	private Integer status;

	//ngay bao duong cuoi cung
	@Column(name = "last_maintenance", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastMaintenance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getChair() {
		return chair;
	}

	public void setChair(Integer chair) {
		this.chair = chair;
	}

	public Integer getYearUsed() {
		return yearUsed;
	}

	public void setYearUsed(Integer yearUsed) {
		this.yearUsed = yearUsed;
	}

	public Date getLastMaintenance() {
		return lastMaintenance;
	}

	public void setLastMaintenance(Date lastMaintenance) {
		this.lastMaintenance = lastMaintenance;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

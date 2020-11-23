package qlhvt.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "driver")
public class Driver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "id_number", nullable = false)
	private String idNumber;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "license_number", nullable = false)
	private String licenseNumber;

	@Column(name = "license_type", nullable = false)
	private String licenseType;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "date_of_birth", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBirth;
	
	@Column(name = "seniority", nullable = false)
	private String seniority;
	
	@Column(name = "status", nullable = false)
	private Integer status;
	
//	@OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<DriverTrip> driverTrip = new ArrayList<>();
//
//	public List<DriverTrip> getDriverTrip() {
//		return driverTrip;
//	}
//
//	public void setDriverTrip(List<DriverTrip> driverTrip) {
//		this.driverTrip = driverTrip;
//	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}

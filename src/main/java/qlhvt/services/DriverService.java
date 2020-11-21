package qlhvt.services;

import java.util.List;

import qlhvt.entities.Driver;

public interface DriverService {
	List<Driver> getAllDriver();
	Driver getDriverById(Integer id);
	void addDriver(Driver driver);
	void updateDriver(Driver driver);
	void deleteDriverById(Integer id);
	List<Driver> searchDriverByCondition(String name, String idNumber, String licenseType, String address);
}

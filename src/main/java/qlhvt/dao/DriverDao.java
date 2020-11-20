package qlhvt.dao;

import java.util.List;

import qlhvt.entities.Driver;

public interface DriverDao {
	List<Driver> getAllDriver();
	Driver getDriverById(Integer id);
	void addDriver(Driver driver);
	void updateDriver(Driver driver);
	void deleteDriverById(Integer id);
}

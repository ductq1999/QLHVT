package qlhvt.services;

import java.util.List;

import qlhvt.entities.Driver;

public interface DriverService {
	List<Driver> getAllDriver();

	Driver getDriverById(Integer id);
	
	Boolean isExist(Driver driver);

	void addDriver(Driver driver);

	void updateDriver(Driver driver);

	void deleteDriverById(Integer id);

	List<Driver> searchDriverByCondition(int page, int pageSize, String columnSortName, Boolean asc, String name,
			String idNumber, String licenseType, String address, Integer status);

	int getRowCount(String name, String idNumber, String licenseType, String address, Integer status);

}

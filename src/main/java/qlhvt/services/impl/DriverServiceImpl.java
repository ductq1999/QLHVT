package qlhvt.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlhvt.dao.DriverDao;
import qlhvt.entities.Driver;
import qlhvt.services.DriverService;

@Service(value = "driverService")
public class DriverServiceImpl implements DriverService{
	
	@Autowired
	private DriverDao driverDao;

	@Override
	public List<Driver> getAllDriver() {
		// TODO Auto-generated method stub
		return driverDao.getAllDriver();
	}

	@Override
	public Driver getDriverById(Integer id) {
		// TODO Auto-generated method stub
		return driverDao.getDriverById(id);
	}

	@Override
	public void addDriver(Driver driver) {
		// TODO Auto-generated method stub
		driverDao.addDriver(driver);
	}

	@Override
	public void updateDriver(Driver driver) {
		// TODO Auto-generated method stub
		driverDao.updateDriver(driver);
	}

	@Override
	public void deleteDriverById(Integer id) {
		// TODO Auto-generated method stub
		driverDao.deleteDriverById(id);
	}

}

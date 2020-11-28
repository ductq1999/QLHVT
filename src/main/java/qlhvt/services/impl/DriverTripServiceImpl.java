package qlhvt.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlhvt.dao.DriverTripDao;
import qlhvt.entities.DriverTrip;
import qlhvt.services.DriverTripService;

@Service(value = "driverTripService")
public class DriverTripServiceImpl implements DriverTripService {

	@Autowired
	private DriverTripDao driverTripDao;

	@Override
	public List<DriverTrip> getAllDriverTrip() {
		// TODO Auto-generated method stub
		return driverTripDao.getAllDriverTrip();
	}

	@Override
	public DriverTrip getDriverTripById(Integer id) {
		// TODO Auto-generated method stub
		return driverTripDao.getDriverTripById(id);
	}

	@Override
	public void addDriverTrip(DriverTrip driverTrip) {
		// TODO Auto-generated method stub
		driverTripDao.addDriverTrip(driverTrip);
	}

	@Override
	public void updateDriverTrip(DriverTrip driverTrip) {
		// TODO Auto-generated method stub
		driverTripDao.updateDriverTrip(driverTrip);
	}

	@Override
	public void deleteDriverTripById(Integer id) {
		// TODO Auto-generated method stub
		driverTripDao.deleteDriverTripById(id);

	}

	@Override
	public List<DriverTrip> searchDriverTripByCondition(int page, int pageSize, String columnSortName, Boolean asc,
			Integer driverType) {
		// TODO Auto-generated method stub
		return driverTripDao.searchDriverTripByCondition(page, pageSize, columnSortName, asc, driverType);
	}

	@Override
	public int getRowCount(Integer driverType) {
		// TODO Auto-generated method stub
		return driverTripDao.getRowCount(driverType);
	}

	@Override
	public List<DriverTrip> getDriverTripByDriverId(Integer id) {
		// TODO Auto-generated method stub
		return driverTripDao.getDriverTripByDriverId(id);
	}

	@Override
	public int salaryMonth(Integer id, Integer month, Integer year) {
		// TODO Auto-generated method stub
		return driverTripDao.salaryMonth(id, month, year);
	}

}

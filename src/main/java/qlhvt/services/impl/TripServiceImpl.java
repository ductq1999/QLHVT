package qlhvt.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlhvt.dao.TripDao;
import qlhvt.entities.Trip;
import qlhvt.services.TripService;

@Service(value = "tripService")
public class TripServiceImpl implements TripService {

	@Autowired
	private TripDao tripDao;

	@Override
	public List<Trip> getAllTrip() {
		// TODO Auto-generated method stub
		return tripDao.getAllTrip();
	}

	@Override
	public Trip getTripById(Integer id) {
		// TODO Auto-generated method stub
		return tripDao.getTripById(id);
	}

	@Override
	public void addTrip(Trip trip) {
		// TODO Auto-generated method stub
		tripDao.addTrip(trip);
	}

	@Override
	public void updateTrip(Trip trip) {
		// TODO Auto-generated method stub
		tripDao.updateTrip(trip);
	}

	@Override
	public void deleteTripById(Integer id) {
		// TODO Auto-generated method stub
		tripDao.deleteTripById(id);
	}

	@Override
	public List<Trip> searchTripByCondition(int page, int pageSize, String columnSortName, Boolean asc, String code,
			Integer status) {
		// TODO Auto-generated method stub
		return tripDao.searchTripByCondition(page, pageSize, columnSortName, asc, code, status);
	}

	@Override
	public int getRowCount(String code, Integer status) {
		// TODO Auto-generated method stub
		return tripDao.getRowCount(code, status);
	}

	@Override
	public List<Trip> getTripByCoachId(Integer id) {
		// TODO Auto-generated method stub
		return tripDao.getTripByCoachId(id);
	}

	public Boolean isExist(Trip trip) {
		// TODO Auto-generated method stub
		return tripDao.isExist(trip);
	}
}

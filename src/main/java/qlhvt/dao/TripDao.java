package qlhvt.dao;

import java.util.List;

import qlhvt.entities.Trip;

public interface TripDao {
	List<Trip> getAllTrip();

	Trip getTripById(Integer id);

	void addTrip(Trip trip);

	void updateTrip(Trip trip);

	void deleteTripById(Integer id);
	
	Boolean isExist(Trip trip);

	List<Trip> searchTripByCondition(int page, int pageSize, String columnSortName, Boolean asc, String code,
			Integer status);

	int getRowCount(String code, Integer status);

	List<Trip> getTripByCoachId(Integer id);
}

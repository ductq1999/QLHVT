package qlhvt.services;

import java.util.List;

import qlhvt.entities.Trip;

public interface TripService {
	List<Trip> getAllTrip();

	Trip getTripById(Integer id);

	void addTrip(Trip trip);
	
	Boolean isExist(Trip trip);

	void updateTrip(Trip trip);

	void deleteTripById(Integer id);

	List<Trip> searchTripByCondition(int page, int pageSize, String columnSortName, Boolean asc, String code,
			Integer status);

	int getRowCount(String code, Integer status);

	List<Trip> getTripByCoachId(Integer id);

}

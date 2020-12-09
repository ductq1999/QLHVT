package qlhvt.services;

import java.util.List;

import qlhvt.entities.Buses;

public interface BusesService {
	List<Buses> getAllBuses();

	Buses getBusesById(Integer id);

	void addBuses(Buses buses);

	void updateBuses(Buses buses);

	void deleteBusesById(Integer id);

	List<Buses> searchBusesByCondition(int page, int pageSize, String columnSortName, Boolean asc, String first,
			String last, Integer length, Integer complexity, Integer status);

	int getRowCount(String first, String last, Integer length, Integer complexity, Integer status);

	Boolean isExist(Buses buses);
}

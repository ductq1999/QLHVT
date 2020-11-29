package qlhvt.services;

import java.util.List;

import qlhvt.entities.Coach;

public interface CoachService {
	List<Coach> getAllCoach();

	Coach getCoachById(Integer id);

	void addCoach(Coach coach);

	void updateCoach(Coach coach);
	
	Boolean isExist(Coach coach);

	void deleteCoachById(Integer id);

	List<Coach> searchCoachByCondition(int page, int pageSize, String columnSortName, Boolean asc, String licensePlate,
			String color, String manufacturer, String carType, String model, Integer chair, Integer status);

	int getRowCount(String licensePlate, String color, String manufacturer, String carType, String model,
			Integer chair, Integer status);
}

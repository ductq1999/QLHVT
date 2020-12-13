package qlhvt.dao;

import java.util.Date;
import java.util.List;

import qlhvt.entities.Coach;

public interface CoachDao {
	List<Coach> getAllCoach();

	Coach getCoachById(Integer id);

	void addCoach(Coach coach);
	
	Boolean isExist(Coach coach);

	void updateCoach(Coach coach);

	void deleteCoachById(Integer id);

	List<Coach> searchCoachByCondition(int page, int pageSize, String columnSortName, Boolean asc, String licensePlate,
			String color, String manufacturer, String carType, String model, Integer chair, Integer status);

	int getRowCount(String licensePlate, String color, String manufacturer, String carType, String model, Integer chair,
			Integer status);
	
	Date getNextMaintenance(Integer id);
	
	int getTotalIncome(Integer id);
	
	List<Coach> getCoachTimeOverdue();
}

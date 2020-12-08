package qlhvt.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlhvt.dao.CoachDao;
import qlhvt.entities.Coach;
import qlhvt.services.CoachService;

@Service(value = "coachService")
public class CoachServiceImpl implements CoachService {

	@Autowired
	private CoachDao coachDao;

	@Override
	public List<Coach> getAllCoach() {
		// TODO Auto-generated method stub
		return coachDao.getAllCoach();
	}

	@Override
	public Coach getCoachById(Integer id) {
		// TODO Auto-generated method stub
		return coachDao.getCoachById(id);
	}

	@Override
	public void addCoach(Coach coach) {
		// TODO Auto-generated method stub
		coachDao.addCoach(coach);
	}

	@Override
	public void updateCoach(Coach coach) {
		// TODO Auto-generated method stub
		coachDao.updateCoach(coach);
	}

	@Override
	public void deleteCoachById(Integer id) {
		// TODO Auto-generated method stub
		coachDao.deleteCoachById(id);

	}

	@Override
	public List<Coach> searchCoachByCondition(int page, int pageSize, String columnSortName, Boolean asc,
			String licensePlate, String color, String manufacturer, String carType, String model, Integer chair,
			Integer status) {
		// TODO Auto-generated method stub
		return coachDao.searchCoachByCondition(page, pageSize, columnSortName, asc, licensePlate, color, manufacturer,
				carType, model, chair, status);
	}

	@Override
	public int getRowCount(String licensePlate, String color, String manufacturer, String carType, String model,
			Integer chair, Integer status) {
		// TODO Auto-generated method stub
		return coachDao.getRowCount(licensePlate, color, manufacturer, carType, model, chair, status);
	}
	
	public Boolean isExist(Coach coach) {
		// TODO Auto-generated method stub
		return coachDao.isExist(coach);
	}
	
	public Date getNextMaintenance(Integer id) {
		// TODO Auto-generated method stub
		return coachDao.getNextMaintenance(id);
	}
	
	@Override
	public int getTotalIncome(Integer id) {
		// TODO Auto-generated method stub
		return coachDao.getTotalIncome(id);
	}
	

}

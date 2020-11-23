package qlhvt.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlhvt.dao.BusesDao;
import qlhvt.entities.Buses;
import qlhvt.services.BusesService;

@Service(value = "busesService")
public class BusesServiceImpl implements BusesService {

	@Autowired
	private BusesDao busesDao;

	@Override
	public List<Buses> getAllBuses() {
		// TODO Auto-generated method stub
		return busesDao.getAllBuses();
	}

	@Override
	public Buses getBusesById(Integer id) {
		// TODO Auto-generated method stub
		return busesDao.getBusesById(id);
	}

	@Override
	public void addBuses(Buses buses) {
		// TODO Auto-generated method stub
		busesDao.addBuses(buses);
	}

	@Override
	public void updateBuses(Buses buses) {
		// TODO Auto-generated method stub
		busesDao.updateBuses(buses);
	}

	@Override
	public void deleteBusesById(Integer id) {
		// TODO Auto-generated method stub
		busesDao.deleteBusesById(id);

	}

	@Override
	public List<Buses> searchBusesByCondition(int page, int pageSize, String columnSortName, Boolean asc, String first,
			String last, String length, Integer complexity, Integer status) {
		// TODO Auto-generated method stub
		return busesDao.searchBusesByCondition(page, pageSize, columnSortName, asc, first, last, length, complexity,
				status);
	}

	@Override
	public int getRowCount(String first, String last, String length, Integer complexity, Integer status) {
		// TODO Auto-generated method stub
		return busesDao.getRowCount(first, last, length, complexity, status);
	}

}

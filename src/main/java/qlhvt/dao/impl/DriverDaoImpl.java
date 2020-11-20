package qlhvt.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlhvt.dao.DriverDao;
import qlhvt.entities.Driver;

@Transactional
@Repository(value="driverDao")
public class DriverDaoImpl implements DriverDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Driver> getAllDriver() {
		// TODO Auto-generated method stub
		String hql = "FROM Driver as d";
		return (List<Driver>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Driver getDriverById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Driver.class, id);
	}

	@Override
	public void addDriver(Driver driver) {
		// TODO Auto-generated method stub
		entityManager.persist(driver);
	}

	@Override
	public void updateDriver(Driver driver) {
		// TODO Auto-generated method stub
		Driver mDriver = entityManager.find(Driver.class, driver.getId());
		driver.setId(mDriver.getId());
		entityManager.merge(driver);
	}

	@Override
	public void deleteDriverById(Integer id) {
		// TODO Auto-generated method stub
		Driver mDriver = entityManager.find(Driver.class, id);
		entityManager.remove(mDriver);
	}

}

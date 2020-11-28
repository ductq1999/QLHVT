package qlhvt.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlhvt.dao.DriverDao;
import qlhvt.entities.Driver;

@Transactional
@Repository(value = "driverDao")
public class DriverDaoImpl implements DriverDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Driver> getAllDriver() {
		// TODO Auto-generated method stub
		String hql = "FROM Driver as d WHERE d.status = 1";
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
		Driver driver = entityManager.find(Driver.class, id);
		driver.setStatus(0);
		entityManager.merge(driver);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<Driver> searchDriverByCondition(int page, int pageSize, String columnSortName, Boolean asc, String name,
			String idNumber, String licenseType, String address, Integer status) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Driver> from = criteriaQuery.from(Driver.class);
		CriteriaQuery<Object> select = criteriaQuery.select(from);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (name != null && !name.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("name"), "%" + name + "%"));
		}
		if (idNumber != null && !idNumber.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("idNumber"), "%" + idNumber + "%"));
		}
		if (licenseType != null && !licenseType.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("licenseType"), "%" + licenseType + "%"));
		}
		if (address != null && !address.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("address"), "%" + address + "%"));
		}
		if (status != null && !status.equals("")) {
			predicates.add(criteriaBuilder.equal(from.get("status"), status));
		}
		select.select(from).where(predicates.toArray(new Predicate[] {}));
		if (columnSortName != null && !columnSortName.equals("")) {
			if (asc == null || asc) {
				select.orderBy(criteriaBuilder.asc(from.get(columnSortName)));
			} else {
				select.orderBy(criteriaBuilder.desc(from.get(columnSortName)));
			}
		}

		Query query = entityManager.createQuery(criteriaQuery);
		if (page >= 0 && pageSize >= 0) {
			query.setFirstResult((page - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		@SuppressWarnings("unchecked")
		List<Driver> lstResult = query.getResultList();
		return lstResult;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public int getRowCount(String name, String idNumber, String licenseType, String address, Integer status) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Driver> from = criteriaQuery.from(Driver.class);
		CriteriaQuery<Object> select = criteriaQuery.select(from);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (name != null && !name.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("name"), "%" + name + "%"));
		}
		if (idNumber != null && !idNumber.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("idNumber"), "%" + idNumber + "%"));
		}
		if (licenseType != null && !licenseType.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("licenseType"), "%" + licenseType + "%"));
		}
		if (address != null && !address.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("address"), "%" + address + "%"));
		}
		;
		if (status != null && !status.equals("")) {
			predicates.add(criteriaBuilder.equal(from.get("status"), status));
		}

		select.select(from).where(predicates.toArray(new Predicate[] {}));
		Query query = entityManager.createQuery(criteriaQuery);

		@SuppressWarnings("unchecked")
		List<Driver> lstResult = query.getResultList();
		return lstResult.size();
	}

	@Override
	public Boolean isExist(Driver driver) {
		// TODO Auto-generated method stub
		String hql = "FROM Driver as d WHERE d.status = 1 AND d.idNumber = :idNumber";
		return entityManager.createQuery(hql).setParameter("idNumber", driver.getIdNumber()).getResultList().size() > 0 ? true : false;
	}

}

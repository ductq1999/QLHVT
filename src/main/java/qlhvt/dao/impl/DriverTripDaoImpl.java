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

import qlhvt.dao.DriverTripDao;
import qlhvt.entities.DriverTrip;

@Transactional
@Repository(value = "driverTripDao")
public class DriverTripDaoImpl implements DriverTripDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<DriverTrip> getAllDriverTrip() {
		// TODO Auto-generated method stub
		String hql = "FROM DriverTrip as d";
		return (List<DriverTrip>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public DriverTrip getDriverTripById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(DriverTrip.class, id);
	}

	@Override
	public void addDriverTrip(DriverTrip driverTrip) {
		// TODO Auto-generated method stub
		entityManager.persist(driverTrip);
	}

	@Override
	public void updateDriverTrip(DriverTrip driverTrip) {
		// TODO Auto-generated method stub
		DriverTrip mDriverTrip = entityManager.find(DriverTrip.class, driverTrip.getId());
		driverTrip.setId(mDriverTrip.getId());
		entityManager.merge(driverTrip);
	}

	@Override
	public void deleteDriverTripById(Integer id) {
		// TODO Auto-generated method stub
		DriverTrip driverTrip = entityManager.find(DriverTrip.class, id);
		entityManager.remove(driverTrip);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<DriverTrip> searchDriverTripByCondition(int page, int pageSize, String columnSortName, Boolean asc,
			Integer driverType) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<DriverTrip> from = criteriaQuery.from(DriverTrip.class);
		CriteriaQuery<Object> select = criteriaQuery.select(from);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (driverType != null && !driverType.equals("")) {
			predicates.add(criteriaBuilder.equal(from.get("driverType"), driverType));
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
		List<DriverTrip> lstResult = query.getResultList();
		return lstResult;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public int getRowCount(Integer driverType) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<DriverTrip> from = criteriaQuery.from(DriverTrip.class);
		CriteriaQuery<Object> select = criteriaQuery.select(from);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (driverType != null && !driverType.equals("")) {
			predicates.add(criteriaBuilder.equal(from.get("driverType"), driverType));
		}
		select.select(from).where(predicates.toArray(new Predicate[] {}));
		Query query = entityManager.createQuery(criteriaQuery);
		@SuppressWarnings("unchecked")
		List<DriverTrip> lstResult = query.getResultList();
		return lstResult.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DriverTrip> getDriverTripByDriverId(Integer id) {
		// TODO Auto-generated method stub
		String hql = "FROM DriverTrip as d WHERE d.driver.id = " + id;
		return (List<DriverTrip>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public int salaryMonth(Integer id, Integer month, Integer year) {
		// TODO Auto-generated method stub
		Integer salaryMonth = 0;

		String hql = "FROM DriverTrip as d WHERE d.id = " + id + " AND month(d.trip.date) = " + month
				+ " AND year(d.trip.date) = " + year;
		@SuppressWarnings("unchecked")
		List<DriverTrip> dtm = entityManager.createQuery(hql).getResultList();
		if (dtm.size() == 0) {
			return 0;
		} else {
			for (int i = 0; i < dtm.size(); i++) {
				salaryMonth += dtm.get(i).getSalaryTrip() * dtm.get(i).getDriverType()
						* dtm.get(i).getTrip().getBuses().getComplexity();
			}
			return salaryMonth;
		}
	}

}

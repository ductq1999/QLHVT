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

import qlhvt.dao.TripDao;
import qlhvt.entities.Trip;

@Transactional
@Repository(value = "tripDao")
public class TripDaoImpl implements TripDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Trip> getAllTrip() {
		// TODO Auto-generated method stub
		String hql = "FROM Trip as t WHERE t.status = 1";
		return (List<Trip>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Trip getTripById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Trip.class, id);
	}

	@Override
	public void addTrip(Trip trip) {
		// TODO Auto-generated method stub
		entityManager.persist(trip);

	}

	@Override
	public Boolean isExist(Trip trip) {
		// TODO Auto-generated method stub
		String hql = "FROM Trip as d WHERE d.status = 1 AND d.code = :code";
		return entityManager.createQuery(hql).setParameter("code", trip.getCode()).getResultList().size() > 0 ? true
				: false;
	}

	@Override
	public void updateTrip(Trip trip) {
		// TODO Auto-generated method stub
		Trip mTrip = entityManager.find(Trip.class, trip.getId());
		trip.setId(mTrip.getId());
		entityManager.merge(trip);
	}

	@Override
	public void deleteTripById(Integer id) {
		// TODO Auto-generated method stub
		Trip trip = entityManager.find(Trip.class, id);
		trip.setStatus(0);
		entityManager.merge(trip);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<Trip> searchTripByCondition(int page, int pageSize, String columnSortName, Boolean asc, String code,
			Integer status) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Trip> from = criteriaQuery.from(Trip.class);
		CriteriaQuery<Object> select = criteriaQuery.select(from);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (code != null && !code.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("code"), "%" + code + "%"));
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
		List<Trip> lstResult = query.getResultList();
		return lstResult;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public int getRowCount(String code, Integer status) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Trip> from = criteriaQuery.from(Trip.class);
		CriteriaQuery<Object> select = criteriaQuery.select(from);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (code != null && !code.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("code"), "%" + code + "%"));
		}
		if (status != null && !status.equals("")) {
			predicates.add(criteriaBuilder.equal(from.get("status"), status));
		}
		select.select(from).where(predicates.toArray(new Predicate[] {}));
		Query query = entityManager.createQuery(criteriaQuery);
		@SuppressWarnings("unchecked")
		List<Trip> lstResult = query.getResultList();
		return lstResult.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trip> getTripByCoachId(Integer id) {
		// TODO Auto-generated method stub
		String hql = "FROM Trip as t WHERE t.status = 1 AND t.coach.id = " + id;
		return (List<Trip>) entityManager.createQuery(hql).getResultList();
	}
}

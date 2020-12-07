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

import qlhvt.dao.BusesDao;
import qlhvt.entities.Buses;

@Transactional
@Repository(value = "busesDao")
public class BusesDaoImpl implements BusesDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Buses> getAllBuses() {
		// TODO Auto-generated method stub
		String hql = "FROM Buses as b WHERE b.status = 1";
		return (List<Buses>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Buses getBusesById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Buses.class, id);
	}

	@Override
	public void addBuses(Buses buses) {
		// TODO Auto-generated method stub
		entityManager.persist(buses);
	}

	@Override
	public void updateBuses(Buses buses) {
		// TODO Auto-generated method stub
		Buses mBuses = entityManager.find(Buses.class, buses.getId());
		buses.setId(mBuses.getId());
		entityManager.merge(buses);
	}

	@Override
	public void deleteBusesById(Integer id) {
		// TODO Auto-generated method stub
		Buses buses = entityManager.find(Buses.class, id);
		buses.setStatus(0);
		entityManager.merge(buses);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<Buses> searchBusesByCondition(int page, int pageSize, String columnSortName, Boolean asc, String first,
			String last, Integer length, Integer complexity, Integer status) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Buses> from = criteriaQuery.from(Buses.class);
		CriteriaQuery<Object> select = criteriaQuery.select(from);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (first != null && !first.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("first"), "%" + first + "%"));
		}
		if (last != null && !last.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("last"), "%" + last + "%"));
		}
		if (length != null && !length.equals("")) {
			predicates.add(criteriaBuilder.equal(from.get("length"), length));
		}
		if (complexity != null && !complexity.equals("")) {
			predicates.add(criteriaBuilder.equal(from.get("complexity"), complexity));
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
		List<Buses> lstResult = query.getResultList();
		return lstResult;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public int getRowCount(String first, String last, Integer length, Integer complexity, Integer status) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Buses> from = criteriaQuery.from(Buses.class);
		CriteriaQuery<Object> select = criteriaQuery.select(from);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (first != null && !first.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("first"), "%" + first + "%"));
		}
		if (last != null && !last.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("last"), "%" + last + "%"));
		}
		if (length != null && !length.equals("")) {
			predicates.add(criteriaBuilder.equal(from.get("length"), length));
		}
		if (complexity != null && !complexity.equals("")) {
			predicates.add(criteriaBuilder.equal(from.get("complexity"), complexity));
		}
		if (status != null && !status.equals("")) {
			predicates.add(criteriaBuilder.equal(from.get("status"), status));
		}
		select.select(from).where(predicates.toArray(new Predicate[] {}));
		Query query = entityManager.createQuery(criteriaQuery);
		@SuppressWarnings("unchecked")
		List<Buses> lstResult = query.getResultList();
		return lstResult.size();
	}

}

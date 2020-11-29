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

import qlhvt.dao.CoachDao;
import qlhvt.entities.Coach;

@Transactional
@Repository(value = "coachDao")
public class CoachDaoImpl implements CoachDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Coach> getAllCoach() {
		// TODO Auto-generated method stub
		String hql = "FROM Coach as c WHERE c.status = 1";
		return (List<Coach>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Coach getCoachById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Coach.class, id);
	}

	@Override
	public void addCoach(Coach coach) {
		// TODO Auto-generated method stub
		entityManager.persist(coach);
	}

	@Override
	public void updateCoach(Coach coach) {
		// TODO Auto-generated method stub
		Coach mCoach = entityManager.find(Coach.class, coach.getId());
		coach.setId(mCoach.getId());
		entityManager.merge(coach);
	}

	@Override
	public void deleteCoachById(Integer id) {
		// TODO Auto-generated method stub
		Coach coach = entityManager.find(Coach.class, id);
		coach.setStatus(0);
		entityManager.merge(coach);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<Coach> searchCoachByCondition(int page, int pageSize, String columnSortName, Boolean asc,
			String licensePlate, String color, String manufacturer, String carType, String model, Integer chair,
			Integer status) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Coach> from = criteriaQuery.from(Coach.class);
		CriteriaQuery<Object> select = criteriaQuery.select(from);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (licensePlate != null && !licensePlate.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("licensePlate"), "%" + licensePlate + "%"));
		}
		if (color != null && !color.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("color"), "%" + color + "%"));
		}
		if (manufacturer != null && !manufacturer.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("manufacturer"), "%" + manufacturer + "%"));
		}
		if (carType != null && !carType.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("carType"), "%" + carType + "%"));
		}
		if (model != null && !model.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("model"), "%" + model + "%"));
		}
		if (chair != null && !chair.equals("")) {
			predicates.add(criteriaBuilder.equal(from.get("chair"), chair));
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
		List<Coach> lstResult = query.getResultList();
		return lstResult;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public int getRowCount(String licensePlate, String color, String manufacturer, String carType, String model,
			Integer chair, Integer status) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Coach> from = criteriaQuery.from(Coach.class);
		CriteriaQuery<Object> select = criteriaQuery.select(from);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (licensePlate != null && !licensePlate.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("licensePlate"), "%" + licensePlate + "%"));
		}
		if (color != null && !color.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("color"), "%" + color + "%"));
		}
		if (manufacturer != null && !manufacturer.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("manufacturer"), "%" + manufacturer + "%"));
		}
		if (carType != null && !carType.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("carType"), "%" + carType + "%"));
		}
		if (model != null && !model.equals("")) {
			predicates.add(criteriaBuilder.like(from.get("model"), "%" + model + "%"));
		}
		if (chair != null && !chair.equals("")) {
			predicates.add(criteriaBuilder.equal(from.get("chair"), chair));
		}
		if (status != null && !status.equals("")) {
			predicates.add(criteriaBuilder.equal(from.get("status"), status));
		}
		select.select(from).where(predicates.toArray(new Predicate[] {}));
		Query query = entityManager.createQuery(criteriaQuery);
		@SuppressWarnings("unchecked")
		List<Coach> lstResult = query.getResultList();
		return lstResult.size();
	}
	
	public Boolean isExist(Coach coach) {
		// TODO Auto-generated method stub
		String hql = "FROM Coach as d WHERE d.status = 1 AND d.license_plate = :license_plate";
		return entityManager.createQuery(hql).setParameter("license_plate", coach.getLicensePlate()).getResultList().size() > 0 ? true : false;
	}

}

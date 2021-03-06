package qlhvt.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qlhvt.dao.CoachDao;
import qlhvt.entities.Coach;
import qlhvt.entities.Trip;

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
		String hql = "FROM Coach as c WHERE c.status = 1 AND c.licensePlate = :licensePlate";
		return entityManager.createQuery(hql).setParameter("licensePlate", coach.getLicensePlate()).getResultList()
				.size() > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Date getNextMaintenance(Integer id) {
		// TODO Auto-generated method stub
		String hql = "FROM Trip as t WHERE t.status = 1 AND t.coach.id = " + id + " AND t.coach.status = 1"
				+ " AND t.date > t.coach.lastMaintenance";
		List<Trip> list = entityManager.createQuery(hql).getResultList();
		if (list.size() == 0) {
			Date date = new Date();
			Coach coach = new Coach();
			coach = this.getCoachById(id);
			date = coach.getLastMaintenance();
			DateTime dt = new DateTime(date);
			return dt.plusDays(360).toDate();
		} else {
			Date d = new Date();
			Integer day = 0;
			for (int i = 0; i < list.size(); i++) {
				day += list.get(i).getBuses().getLength() * list.get(i).getBuses().getComplexity() / 100;
				d = list.get(0).getCoach().getLastMaintenance();
			}
			DateTime dt = new DateTime(d);
			return dt.plusDays(360 - day).toDate();
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public int getTotalIncome(Integer id) {
		// TODO Auto-generated method stub
		Integer totalIncome = 0;
		String hql = "FROM Trip as t WHERE t.status = 1 AND t.coach.id = " + id;
		List<Trip> list = entityManager.createQuery(hql).getResultList();
		if (list.size() == 0) {
			return 0;
		} else {
			for (int i = 0; i < list.size(); i++) {
				totalIncome += list.get(i).getFare() * list.get(i).getGuestNumber();
			}
			return totalIncome;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Coach> getCoachTimeOverdue() {
		// TODO Auto-generated method stub
		Date date = new Date();
		String hql = "FROM Coach as c WHERE c.status = 1";
		List<Coach> list = entityManager.createQuery(hql).getResultList();
		List<Coach> coachOverDue = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			if(this.getNextMaintenance(list.get(i).getId()).before(date)) {
				coachOverDue.add(list.get(i));
			}
		}
		return coachOverDue;
	}

}

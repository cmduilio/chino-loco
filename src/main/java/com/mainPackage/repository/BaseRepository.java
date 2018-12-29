package com.mainPackage.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


//implementation of daydao interface using entityManager
public abstract class BaseRepository<T> implements Repository<T> {

	private static final Logger logger = LoggerFactory.getLogger(BaseRepository.class);

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public void add(T p) {
		entityManager.persist(p);
		logger.info("T saved successfully, T Details=" + p);
	}

    @Transactional
	public void update(T p) {
		entityManager.merge(p);
		logger.info("T updated successfully, T Details=" + p);
	}

    @Transactional
	@SuppressWarnings("unchecked")
	public List<T> getList(Class<T> zClass) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(zClass);
        Root<T> rootEntry = cq.from(zClass);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = entityManager.createQuery(all);

		List<T> daysList = allQuery.getResultList();
		for (T p : daysList) {
			logger.info("T List::" + p);
		}
		return daysList;
	}

    @Transactional
	public T getById(int id, Class<T> zClass) {
		T p = (T) entityManager.find(zClass, id);
		logger.info("T loaded successfully, T details=" + p);
		return p;
	}

    @Transactional
	public void remove(int id, Class<T> zClass) {
		T p = (T) entityManager.find(zClass, new Integer(id));
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("T deleted successfully, T details=" + p);
	}
}

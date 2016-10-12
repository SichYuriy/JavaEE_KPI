package com.gmail.at.sichyuriyy.lab3.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.gmail.at.sichyuriyy.lab3.jpa.entities.Producer;

public class ProducerDAO extends DAO<Producer> {

	private static ProducerDAO dao;

	public static ProducerDAO getInstance() {
		if (dao == null) {
			dao = new ProducerDAO();
		}
		return dao;
	}

	private ProducerDAO() {
		super();
	}

	@Override
	public void create(Producer producer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(producer);
		entityTransaction.commit();

		entityManager.close();

	}

	@Override
	public void delete(Producer producer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		Producer p = entityManager.find(Producer.class, producer.getId());
		entityManager.remove(p);
		entityTransaction.commit();

		entityManager.close();

	}

	@Override
	public void update(Producer producer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(producer);
		entityTransaction.commit();

		entityManager.close();

	}

	@Override
	public List<Producer> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		List<Producer> producers = entityManager.createNamedQuery("findAllProducers", Producer.class).getResultList();
		entityTransaction.commit();

		entityManager.close();
		return producers;
	}

	@Override
	public Producer getById(long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		Producer producer = entityManager.find(Producer.class, id);
		entityTransaction.commit();

		entityManager.close();
		return producer;
	}

}

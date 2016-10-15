package com.gmail.at.sichyuriyy.lab3.jpa.dao;

import java.util.List;

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
		beginTransaction();
		entityManager.persist(producer);
		endTransaction();

	}

	@Override
	public void delete(Producer producer) {
		beginTransaction();
		Producer p = entityManager.find(Producer.class, producer.getId());
		entityManager.remove(p);
		endTransaction();

	}

	@Override
	public void update(Producer producer) {
		beginTransaction();
		entityManager.merge(producer);
		endTransaction();

	}

	@Override
	public List<Producer> getAll() {
		beginTransaction();
		List<Producer> producers = entityManager.createNamedQuery("findAllProducers", Producer.class).getResultList();
		endTransaction();
		return producers;
	}

	@Override
	public Producer getById(long id) {
		beginTransaction();
		Producer producer = entityManager.find(Producer.class, id);
		endTransaction();
		return producer;
	}

}

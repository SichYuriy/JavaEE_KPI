package com.gmail.at.sichyuriyy.lab5.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.gmail.at.sichyuriyy.lab5.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.Producer;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.WatchList;

@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless
public class ProducerDAO extends AbstractDAO<Producer> {

	public ProducerDAO() {
		super();
	}

	@Override
	public void create(Producer producer) {
		entityManager.persist(producer);
	}

	@Override
	public void delete(long id) {
		Producer p = entityManager.find(Producer.class, id);
		for (Movie m : p.getMovies()) {
			for (WatchList list : m.getWatchLists()) {
				list.getMovies().remove(m);
			}
		}
		entityManager.remove(p);

	}

	@Override
	public void update(Producer producer) {
		entityManager.merge(producer);

	}

	@Override
	public List<Producer> getAll() {
		List<Producer> producers = entityManager.createNamedQuery("findAllProducers", Producer.class).getResultList();
		return producers;
	}

	@Override
	public Producer getById(long id) {
		Producer producer = entityManager.find(Producer.class, id);
		return producer;
	}

}

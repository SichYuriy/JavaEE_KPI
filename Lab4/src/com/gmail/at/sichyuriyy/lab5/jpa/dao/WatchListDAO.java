package com.gmail.at.sichyuriyy.lab5.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.gmail.at.sichyuriyy.lab5.jpa.entities.WatchList;

@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless
public class WatchListDAO extends AbstractDAO<WatchList> {
	
	
	public WatchListDAO() {
		super();
	}

	@Override
	public void create(WatchList watchList) {
		entityManager.persist(watchList);

	}

	@Override
	public void delete(long id) {
		entityManager.remove(id);
		
	}

	@Override
	public void update(WatchList watchList) {
		entityManager.merge(watchList);
		
	}

	@Override
	public List<WatchList> getAll() {
		List<WatchList> lists = entityManager.createNamedQuery("getAllWatchLists", WatchList.class).getResultList();
		return lists;
		
	}

	@Override
	public WatchList getById(long id) {
		WatchList watchList = entityManager.find(WatchList.class, id);
		return watchList;
	}

}

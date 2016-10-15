package com.gmail.at.sichyuriyy.lab3.jpa.dao;

import java.util.List;

import com.gmail.at.sichyuriyy.lab3.jpa.entities.WatchList;

public class WatchListDAO extends DAO<WatchList> {
	
	private static WatchListDAO dao;
	
	public static WatchListDAO getInstance() {
		if (dao == null) {
			dao = new WatchListDAO();
		}
		return dao;
	}
	
	private WatchListDAO() {
		super();
	}

	@Override
	public void create(WatchList watchList) {
		beginTransaction();
		entityManager.persist(watchList);
		entityTransaction.commit();

		entityManager.close();
		
	}

	@Override
	public void delete(WatchList watchList) {
		beginTransaction();
		WatchList wl = entityManager.find(WatchList.class, watchList.getId());
		entityManager.remove(wl);
		endTransaction();
		
	}

	@Override
	public void update(WatchList watchList) {
		beginTransaction();
		entityManager.merge(watchList);
		endTransaction();
		
	}

	@Override
	public List<WatchList> getAll() {
		beginTransaction();
		List<WatchList> lists = entityManager.createNamedQuery("getAllWatchLists", WatchList.class).getResultList();
		endTransaction();
		return lists;
		
	}

	@Override
	public WatchList getById(long id) {
		beginTransaction();
		WatchList watchList = entityManager.find(WatchList.class, id);
		beginTransaction();
		return watchList;
	}

}

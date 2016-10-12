package com.gmail.at.sichyuriyy.lab3.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(watchList);
		entityTransaction.commit();

		entityManager.close();
		
	}

	@Override
	public void delete(WatchList watchList) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		WatchList wl = entityManager.find(WatchList.class, watchList.getId());
		entityManager.remove(wl);
		entityTransaction.commit();

		entityManager.close();
		
	}

	@Override
	public void update(WatchList watchList) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(watchList);
		entityTransaction.commit();

		entityManager.close();
		
	}

	@Override
	public List<WatchList> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		List<WatchList> lists = entityManager.createNamedQuery("getAllWatchLists", WatchList.class).getResultList();
		entityTransaction.commit();

		entityManager.close();
		return lists;
		
	}

	@Override
	public WatchList getById(long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		WatchList watchList = entityManager.find(WatchList.class, id);
		entityTransaction.commit();

		entityManager.close();
		return watchList;
	}

}

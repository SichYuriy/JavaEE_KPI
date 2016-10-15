package com.gmail.at.sichyuriyy.lab3.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public abstract class DAO<T> {
	
	
	
	protected EntityManagerFactory entityManagerFactory = SingleEntityManagerFactory.getInstace();
	protected EntityManager entityManager;
	protected EntityTransaction entityTransaction;
	
	public abstract void create(T obj);
	public abstract void delete(T obj);
	public abstract void update(T obj);
	public abstract List<T> getAll();
	public abstract T getById(long id);
	
	protected void beginTransaction() {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	}
	
	protected void endTransaction() {
		entityTransaction.commit();
		entityManager.close();
		
	}
	
	
	
	
}

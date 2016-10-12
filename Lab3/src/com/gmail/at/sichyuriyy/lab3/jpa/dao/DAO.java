package com.gmail.at.sichyuriyy.lab3.jpa.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

public abstract class DAO<T> {
	
	
	
	protected EntityManagerFactory entityManagerFactory = SingleEntityManagerFactory.getInstace();
	
	public abstract void create(T obj);
	public abstract void delete(T obj);
	public abstract void update(T obj);
	public abstract List<T> getAll();
	public abstract T getById(long id);
	
	
}

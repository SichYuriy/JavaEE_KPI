package com.gmail.at.sichyuriyy.lab5.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public abstract class DAO<T> {
	
	@PersistenceContext(unitName="Lab5")
	protected EntityManager entityManager;
	
	public abstract void create(T obj);
	public abstract void delete(long id);
	public abstract void update(T obj);
	public abstract List<T> getAll();
	public abstract T getById(long id);
	
}

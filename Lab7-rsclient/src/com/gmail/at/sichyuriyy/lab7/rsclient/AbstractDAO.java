package com.gmail.at.sichyuriyy.lab7.rsclient;

import java.util.List;

public abstract class AbstractDAO<T> {
	
	
	public abstract void create(T obj);
	public abstract void delete(long id);
	public abstract void update(T obj);
	public abstract List<T> getAll();
	public abstract T getById(long id);
	
}

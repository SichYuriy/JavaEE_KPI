package com.gmail.at.sichyuriyy.lab5.services;

import java.util.List;

public interface ServiceCRUD<T> {
	
	public void create(T obj);
	public void update(T obj);
	public void delete(long id);
	public T getById(long id);
	public List<T> getAll();
	
}

package com.gmail.at.sichyuriyy.lab3.services;

import java.util.List;

import com.gmail.at.sichyuriyy.lab3.jpa.dao.ProducerDAO;
import com.gmail.at.sichyuriyy.lab3.jpa.entities.Producer;

public class ProducerService implements ServiceCRUD<Producer> {
	
	private ProducerDAO producerDAO = ProducerDAO.getInstance();

	@Override
	public void create(Producer producer) {
		producerDAO.create(producer);
	}
	
	public void create(String firstName, String lastName) {
		Producer producer = new Producer();
		producer.setFirstName(firstName);
		producer.setLastName(lastName);
		
		create(producer);
	}

	@Override
	public void update(Producer producer) {
		producerDAO.update(producer);
	}
	
	public void update(long id, String firstName, String lastName) {
		Producer producer = producerDAO.getById(id);
		producer.setFirstName(firstName);
		producer.setLastName(lastName);
		update(producer);
	}

	@Override
	public void delete(long id) {
		producerDAO.delete(id);
		
	}

	@Override
	public Producer getById(long id) {
		return producerDAO.getById(id);
	}

	@Override
	public List<Producer> getAll() {
		return producerDAO.getAll();
	}

}

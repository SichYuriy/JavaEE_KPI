package com.gmail.at.sichyuriyy.lab5.services;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.gmail.at.sichyuriyy.lab5.jpa.dao.ProducerDAO;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.Producer;
import com.gmail.at.sichyuriyy.lab5.jpa.entitiesDTO.ProducerBean;

@ManagedBean(name="producerService")
@ApplicationScoped
public class ProducerService implements ServiceCRUD<Producer> {
	
    @EJB
	private ProducerDAO producerDAO;
	
	@Override
	public void create(Producer producer) {
		producerDAO.create(producer);
	}
	
	public String create(String firstName, String lastName) {
		Producer producer = new Producer();
		producer.setFirstName(firstName);
		producer.setLastName(lastName);
		
		create(producer);
		return "producers";
	}
	
	public String create(ProducerBean producer) {
		create(producer.getFirstName(), producer.getLastName());
		return "producers";
	}

	@Override
	public void update(Producer producer) {
		producerDAO.update(producer);
	}
	
	public String update(long id, String firstName, String lastName) {
		Producer producer = producerDAO.getById(id);
		producer.setFirstName(firstName);
		producer.setLastName(lastName);
		update(producer);
		return "producers";
	}
	
	public String update(ProducerBean producer) {
		update(producer.getId(), producer.getFirstName(), producer.getLastName());
		return "producers";
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

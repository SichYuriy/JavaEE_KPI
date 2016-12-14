package com.gmail.at.sichyuriyy.lab7.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;
import javax.xml.ws.WebServiceRef;

import com.gmail.at.sichyuriyy.lab7.jpa.entitiesDTO.ProducerBean;
import com.gmail.at.sichyuriyy.lab7.wsclient.Producer;
import com.gmail.at.sichyuriyy.lab7.wsclient.ProducerServiceImplService;
import com.gmail.at.sichyuriyy.lab7.wsclient.ProducerWS;

@Named
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
@Stateless
public class ProducerService implements ServiceCRUD<Producer> {
	
    @WebServiceRef(wsdlLocation = "http://localhost:8081/Lab7-0.0.1-SNAPSHOT/ProducerServiceImpl?wsdl")
    private ProducerServiceImplService producerServiceImpl;

    private ProducerWS producerWS;

    @PostConstruct
    protected void init() {
        producerWS = producerServiceImpl.getProducerServiceImplPort();
    }
    
	@Override
	public void create(Producer producer) {
		producerWS.createProducer(producer);
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
		producerWS.updateProducer(producer);
	}
	
	public String update(long id, String firstName, String lastName) {
		Producer producer = producerWS.getProducerById(id);
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
		producerWS.deleteProducer(id);
		
	}

	@Override
	public Producer getById(long id) {
		return producerWS.getProducerById(id);
	}

	@Override
	public List<Producer> getAll() {
		return producerWS.getAllProducers();
	}

	

}

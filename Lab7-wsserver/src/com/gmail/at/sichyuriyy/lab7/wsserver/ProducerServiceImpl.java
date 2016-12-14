package com.gmail.at.sichyuriyy.lab7.wsserver;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.gmail.at.sichyuriyy.lab7.jpa.dao.ProducerDAO;
import com.gmail.at.sichyuriyy.lab7.jpa.entities.Producer;

@Stateless
@WebService(endpointInterface = "com.gmail.at.sichyuriyy.lab7.wsserver.ProducerWS")
public class ProducerServiceImpl implements ProducerWS {
    
    @EJB
    private ProducerDAO producerDAO;

    @Override
    public void createProducer(Producer producer) {
        producerDAO.create(producer);
    }

    @Override
    public void deleteProducer(long id) {
        producerDAO.delete(id);
    }

    @Override
    public void updateProducer(Producer producer) {
        producerDAO.update(producer);
    }

    @Override
    public List<Producer> getAllProducers() {
        return producerDAO.getAll();
    }

    @Override
    public Producer getProducerById(long id) {
        return producerDAO.getById(id);
    }

    public ProducerDAO getProducerDAO() {
        return producerDAO;
    }

    public void setProducerDAO(ProducerDAO producerDAO) {
        this.producerDAO = producerDAO;
    }

}

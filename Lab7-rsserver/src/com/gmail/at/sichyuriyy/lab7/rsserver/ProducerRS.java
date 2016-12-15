package com.gmail.at.sichyuriyy.lab7.rsserver;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gmail.at.sichyuriyy.lab7.jpa.dao.ProducerDAO;
import com.gmail.at.sichyuriyy.lab7.jpa.entities.Producer;

@Path("/producers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class ProducerRS {
    
    @EJB
    private ProducerDAO producerDAO;
    
    @POST
    public void createProducer(Producer producer) {
        producerDAO.create(producer);
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteProducer(@PathParam("id") long id) {
        producerDAO.delete(id);
    }
    
    @PUT
    public void updateProducer(Producer producer) {
        producerDAO.update(producer);
    }
    
    @GET
    public List<Producer> getAllProducers() {
        return producerDAO.getAll();
    }
    
    @GET
    @Path("/{id}")
    public Producer getProducerById(@PathParam("id") long id) {
        return producerDAO.getById(id);
    }

    public ProducerDAO getProducerDAO() {
        return producerDAO;
    }

    public void setProducerDAO(ProducerDAO producerDAO) {
        this.producerDAO = producerDAO;
    }

}

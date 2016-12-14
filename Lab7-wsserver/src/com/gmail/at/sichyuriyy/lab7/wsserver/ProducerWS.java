package com.gmail.at.sichyuriyy.lab7.wsserver;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.gmail.at.sichyuriyy.lab7.jpa.entities.Producer;

@WebService
public interface ProducerWS {
    
    @WebMethod
    public void createProducer(Producer producer);
    
    @WebMethod
    public void deleteProducer(long id);
    
    @WebMethod
    public void updateProducer(Producer producer);
    
    @WebMethod
    public List<Producer> getAllProducers();
    
    @WebMethod
    public Producer getProducerById(long id);
    

}

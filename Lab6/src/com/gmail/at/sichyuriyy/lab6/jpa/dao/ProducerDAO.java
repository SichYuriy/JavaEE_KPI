package com.gmail.at.sichyuriyy.lab6.jpa.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gmail.at.sichyuriyy.lab6.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab6.jpa.entities.Producer;

@TransactionManagement(TransactionManagementType.CONTAINER)
@Stateless
public class ProducerDAO extends AbstractDAO<Producer> {

    @EJB
    private MovieDAO movieDAO;
    
    @Resource
    private EJBContext context;

    private Logger logger;

    public ProducerDAO() {
        super();
    }

    @PostConstruct
    public void init() {
        logger = LogManager.getLogger(ProducerDAO.class);
    }

    @Override
    public void create(Producer producer) {
        entityManager.persist(producer);
    }

    @Override
    public void delete(long id) {
        Producer p = entityManager.find(Producer.class, id);
        for (Movie m : p.getMovies()) {
            try {
                movieDAO.delete(m.getId());
            } catch (Exception e) {
                logger.error(e);
                context.setRollbackOnly();
            }

        }
        entityManager.remove(p);

    }

    @Override
    public void update(Producer producer) {
        entityManager.merge(producer);

    }

    @Override
    public List<Producer> getAll() {
        List<Producer> producers = null;
        producers = entityManager.createNamedQuery("findAllProducers", Producer.class).getResultList();
        return producers;
    }

    @Override
    public Producer getById(long id) {
        Producer producer = null;
        producer = entityManager.find(Producer.class, id);

        return producer;
    }

}

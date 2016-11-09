package com.gmail.at.sichyuriyy.lab5.jpa.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.UserTransaction;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gmail.at.sichyuriyy.lab5.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.Producer;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.WatchList;

@TransactionManagement(TransactionManagementType.BEAN)
@Stateless
public class ProducerDAO extends AbstractDAO<Producer> {
    
    @EJB
    private MovieDAO movieDAO;

    @Resource
    private UserTransaction transaction;

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
        try {
            transaction.begin();
            entityManager.persist(producer);
            transaction.commit();

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(long id) {
        try {
            transaction.begin();
            Producer p = entityManager.find(Producer.class, id);
            for (Movie m : p.getMovies()) {
                try {
                    movieDAO.delete(m.getId());
                } catch (Exception e) {
                    transaction.rollback();
                }
                
            }
            entityManager.remove(p);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    @Override
    public void update(Producer producer) {
        try {
            transaction.begin();
            entityManager.merge(producer);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    @Override
    public List<Producer> getAll() {
        List<Producer> producers = null;
        try {
            transaction.begin();
            producers = entityManager.createNamedQuery("findAllProducers", Producer.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.error(e.getMessage());
        }
        return producers;
    }

    @Override
    public Producer getById(long id) {
        Producer producer = null;
        try {
            transaction.begin();
            producer = entityManager.find(Producer.class, id);
            
               
            transaction.commit();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return producer;
    }

}

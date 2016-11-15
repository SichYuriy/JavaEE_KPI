package com.gmail.at.sichyuriyy.lab5.jpa.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.log4j.Logger;

import com.gmail.at.sichyuriyy.lab5.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.WatchList;

@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless
public class MovieDAO extends AbstractDAO<Movie> {

    private Logger logger;

    public MovieDAO() {
        super();
    }

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(MovieDAO.class);
    }

    @Override
    public void create(Movie movie) {
        entityManager.persist(movie);
    }

    @Override
    public void delete(long id) {
        Movie m = entityManager.find(Movie.class, id);
        for (WatchList list : m.getWatchLists()) {
            list.getMovies().remove(m);
        }
        entityManager.remove(m);

    }

    @Override
    public void update(Movie movie) {
        entityManager.merge(movie);

    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = entityManager.createNamedQuery("findAllMovies", Movie.class).getResultList();
        return movies;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public Movie getById(long id) {
        Movie movie = entityManager.find(Movie.class, id);
        return movie;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void requiredExample() {
        logger.info("from required");
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void requiresNewExample() {
        logger.info("from requiresNew");
    }
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void mandatoryExample() {
        logger.info("from mandatory");
    }
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void notSupportedExample() {
        logger.info("from notSupported");
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public void supportsExample() {
        logger.info("from supports");
    }
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void neverExample() {
        logger.info("from never");
    }

}

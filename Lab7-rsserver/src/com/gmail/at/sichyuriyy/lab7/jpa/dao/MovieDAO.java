package com.gmail.at.sichyuriyy.lab7.jpa.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.log4j.Logger;

import com.gmail.at.sichyuriyy.lab7.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab7.jpa.entities.WatchList;

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

    @Override
    public Movie getById(long id) {
        Movie movie = entityManager.find(Movie.class, id);
        return movie;
    }

   

}

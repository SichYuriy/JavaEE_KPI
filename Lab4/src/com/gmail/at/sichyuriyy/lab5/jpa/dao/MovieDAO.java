package com.gmail.at.sichyuriyy.lab5.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.gmail.at.sichyuriyy.lab5.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.WatchList;


@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless
public class MovieDAO extends AbstractDAO<Movie> {
	
	public MovieDAO() {
		super();
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
	
	

	

}

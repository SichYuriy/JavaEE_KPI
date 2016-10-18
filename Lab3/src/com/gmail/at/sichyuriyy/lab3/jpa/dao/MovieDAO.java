package com.gmail.at.sichyuriyy.lab3.jpa.dao;

import java.util.List;

import com.gmail.at.sichyuriyy.lab3.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab3.jpa.entities.WatchList;

public class MovieDAO extends DAO<Movie> {
	
	private static MovieDAO dao;
	
	public static MovieDAO getInstance() {
		if (dao == null) {
			dao = new MovieDAO();
		}
		return dao;
	}
	
	
	private MovieDAO() {
		super();
	}

	@Override
	public void create(Movie movie) {
		beginTransaction();
		entityManager.persist(movie);
		endTransaction();
		
		
	}

	@Override
	public void delete(long id) {
		beginTransaction();
		Movie m = entityManager.find(Movie.class, id);
		for (WatchList list : m.getWatchLists()) {
			list.getMovies().remove(m);
		}
		entityManager.remove(m);
		endTransaction();
		
	}

	@Override
	public void update(Movie movie) {
		beginTransaction();
		entityManager.merge(movie);
		endTransaction();
		
	}

	@Override
	public List<Movie> getAll() {
		beginTransaction();
		List<Movie> movies = entityManager.createNamedQuery("findAllMovies", Movie.class).getResultList();
		endTransaction();
		return movies;
	}

	@Override
	public Movie getById(long id) {
		beginTransaction();
		Movie movie = entityManager.find(Movie.class, id);
		endTransaction();
		return movie;
	}

	

}

package com.gmail.at.sichyuriyy.lab3.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.gmail.at.sichyuriyy.lab3.jpa.entities.Movie;

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
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(movie);
		entityTransaction.commit();
		
		entityManager.close();
		
	}

	@Override
	public void delete(Movie movie) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		Movie m = entityManager.find(Movie.class, movie.getId());
		entityManager.remove(m);
		entityTransaction.commit();
		
		entityManager.close();
		
	}

	@Override
	public void update(Movie movie) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(movie);
		entityTransaction.commit();
		
		entityManager.close();
		
	}

	@Override
	public List<Movie> getAll() {
		System.out.println(entityManagerFactory == null);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		List<Movie> movies = entityManager.createNamedQuery("findAllMovies", Movie.class).getResultList();
		entityTransaction.commit();
		
		entityManager.close();
		return movies;
	}

	@Override
	public Movie getById(long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		Movie movie = entityManager.find(Movie.class, id);
		entityTransaction.commit();
		
		entityManager.close();
		return movie;
	}

	

}

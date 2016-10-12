package lection.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import lection.entities.Movie;

public class MovieService {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LectionExample");
	
	public void createMovie(Movie movie) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		em.persist(movie);
		tx.commit();
		em.close();
		
	}
	
	public List<Movie> getALlMovies() {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		List<Movie> movies = em.createNamedQuery("getAllMovies").getResultList();
		tx.commit();
		em.close();
		
		return movies;
	}
	
}

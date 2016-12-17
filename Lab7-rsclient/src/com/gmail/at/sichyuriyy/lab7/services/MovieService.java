package com.gmail.at.sichyuriyy.lab7.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;

import com.gmail.at.sichyuriyy.lab7.entities.Movie;
import com.gmail.at.sichyuriyy.lab7.entities.Producer;
import com.gmail.at.sichyuriyy.lab7.entities.Rating;
import com.gmail.at.sichyuriyy.lab7.jpa.entitiesDTO.MovieBean;
import com.gmail.at.sichyuriyy.lab7.rsclient.MovieRestDAO;
import com.gmail.at.sichyuriyy.lab7.rsclient.ProducerRestDAO;

@Named
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
@Stateless
public class MovieService implements ServiceCRUD<Movie> {
    
    
    @EJB
    private MovieRestDAO movieDAO;
    
    @EJB
    private ProducerRestDAO producerDAO;

	@Override
	public void create(Movie movie) {
		movieDAO.create(movie);
		
		
	}

	public String create(long producerId, String title, int year, int duration, String description, double imdbRating,
			double kinoPoiskRating, double rottenTomatosRating) {
		Movie movie = new Movie();

		movie.setTitle(title);
		movie.setDescription(description);
		movie.setDuration(duration);
		movie.setYear(year);

		Rating rating = new Rating();

		rating.setImdbRating(imdbRating);
		rating.setKinoPoiskRating(kinoPoiskRating);
		rating.setRottenTomatosRating(rottenTomatosRating);

		movie.setRating(rating);

		Producer producer = producerDAO.getById(producerId);

		movie.setProducer(producer);

		this.create(movie);
		
		return "index";

	}

	public String create(MovieBean movie) {
		create(movie.getProducerId(), movie.getTitle(), movie.getYear(), movie.getDuration(), movie.getDescription(),
				movie.getRating().getImdbRating(), movie.getRating().getKinoPoiskRating(),
				movie.getRating().getRottenTomatosRating());
		return "index";
	}

	@Override
	public void update(Movie movie) {
		movieDAO.update(movie);

	}

	public String update(long movieId, long producerId, String title, int year, int duration, String description,
			double imdbRating, double kinoPoiskRating, double rottenTomatosRating) {
		Movie movie = movieDAO.getById(movieId);

		movie.setTitle(title);
		movie.setDescription(description);
		movie.setDuration(duration);

		Rating rating = new Rating();

		rating.setImdbRating(imdbRating);
		rating.setKinoPoiskRating(kinoPoiskRating);
		rating.setRottenTomatosRating(rottenTomatosRating);

		movie.setRating(rating);

		Producer producer = producerDAO.getById(producerId);
		movie.setProducer(producer);

		update(movie);
		return "index";
	}

	public String update(MovieBean movie) {
		update(movie.getId(), movie.getProducerId(), movie.getTitle(), movie.getYear(), movie.getDuration(),
				movie.getDescription(), movie.getRating().getImdbRating(), movie.getRating().getKinoPoiskRating(),
				movie.getRating().getRottenTomatosRating());
		return "index";
	}

	@Override
	public void delete(long id) {
		movieDAO.delete(id);
	}

	@Override
	public Movie getById(long id) {
		return movieDAO.getById(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public List<Movie> getAll() {
	   
		return movieDAO.getAll();
	}
	
}

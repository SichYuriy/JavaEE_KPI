package com.gmail.at.sichyuriyy.lab5.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;

import com.gmail.at.sichyuriyy.lab5.jpa.dao.MovieDAO;
import com.gmail.at.sichyuriyy.lab5.jpa.dao.ProducerDAO;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.Producer;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.Rating;
import com.gmail.at.sichyuriyy.lab5.jpa.entitiesDTO.MovieBean;

@Named
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
@Stateless
public class MovieService implements ServiceCRUD<Movie> {

    @EJB
	private MovieDAO movieDAO;

    @EJB
	private ProducerDAO producerDAO;

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
	    movieDAO.mandatoryExample();
        //movieDAO.neverExample();
        //movieDAO.supportsExample();
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

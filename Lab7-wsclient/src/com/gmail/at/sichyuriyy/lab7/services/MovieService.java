package com.gmail.at.sichyuriyy.lab7.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;
import javax.xml.ws.WebServiceRef;

import com.gmail.at.sichyuriyy.lab7.jpa.entitiesDTO.MovieBean;
import com.gmail.at.sichyuriyy.lab7.wsclient.Movie;
import com.gmail.at.sichyuriyy.lab7.wsclient.MovieServiceImplService;
import com.gmail.at.sichyuriyy.lab7.wsclient.MovieWS;
import com.gmail.at.sichyuriyy.lab7.wsclient.Producer;
import com.gmail.at.sichyuriyy.lab7.wsclient.ProducerServiceImplService;
import com.gmail.at.sichyuriyy.lab7.wsclient.ProducerWS;
import com.gmail.at.sichyuriyy.lab7.wsclient.Rating;

@Named
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
@Stateless
public class MovieService implements ServiceCRUD<Movie> {
    
    
    @WebServiceRef(wsdlLocation = "http://localhost:8081/Lab7-0.0.1-SNAPSHOT/MovieServiceImpl?wsdl")
    private MovieServiceImplService movieServiceImpl;
    @WebServiceRef(wsdlLocation = "http://localhost:8081/Lab7-0.0.1-SNAPSHOT/ProducerServiceImpl?wsdl")
    private ProducerServiceImplService producerServiceImpl;

    private MovieWS movieWS;
    private ProducerWS producerWS;

    @PostConstruct
    protected void init() {
        movieWS = movieServiceImpl.getMovieServiceImplPort();
        producerWS = producerServiceImpl.getProducerServiceImplPort();
    }
    
	@Override
	public void create(Movie movie) {
		movieWS.createMovie(movie);
		
		
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

		Producer producer = producerWS.getProducerById(producerId);

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
		movieWS.updateMovie(movie);

	}

	public String update(long movieId, long producerId, String title, int year, int duration, String description,
			double imdbRating, double kinoPoiskRating, double rottenTomatosRating) {
		Movie movie = movieWS.getMovieById(movieId);

		movie.setTitle(title);
		movie.setDescription(description);
		movie.setDuration(duration);

		Rating rating = new Rating();

		rating.setImdbRating(imdbRating);
		rating.setKinoPoiskRating(kinoPoiskRating);
		rating.setRottenTomatosRating(rottenTomatosRating);

		movie.setRating(rating);

		Producer producer = producerWS.getProducerById(producerId);
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
		movieWS.deleteMovie(id);
	}

	@Override
	public Movie getById(long id) {
		return movieWS.getMovieById(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public List<Movie> getAll() {
	   
		return movieWS.getAllMovies();
	}
	
}

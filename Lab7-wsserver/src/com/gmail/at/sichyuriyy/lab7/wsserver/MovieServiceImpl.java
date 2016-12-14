package com.gmail.at.sichyuriyy.lab7.wsserver;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.gmail.at.sichyuriyy.lab7.jpa.dao.MovieDAO;
import com.gmail.at.sichyuriyy.lab7.jpa.entities.Movie;

@Stateless
@WebService(endpointInterface = "com.gmail.at.sichyuriyy.lab7.wsserver.MovieWS")
public class MovieServiceImpl implements MovieWS {

    @EJB 
    private MovieDAO movieDAO;
    
    @Override
    public void createMovie(Movie movie) {
        movieDAO.create(movie);
    }

    @Override
    public void deleteMovie(long id) {
        movieDAO.delete(id);;
    }

    @Override
    public void updateMovie(Movie movie) {
        movieDAO.update(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDAO.getAll();
    }

    @Override
    public Movie getMovieById(long id) {
        return movieDAO.getById(id);
    }

    public MovieDAO getMovieDAO() {
        return movieDAO;
    }

    public void setMovieDAO(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

}

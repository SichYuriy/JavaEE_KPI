package com.gmail.at.sichyuriyy.lab7.wsserver;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.gmail.at.sichyuriyy.lab7.jpa.entities.Movie;

@WebService
public interface MovieWS {
    
    @WebMethod
    public void createMovie(Movie movie);
    @WebMethod
    public void deleteMovie(long id);
    @WebMethod
    public void updateMovie(Movie movie);
    @WebMethod
    public List<Movie> getAllMovies();
    @WebMethod
    public Movie getMovieById(long id);

}

package com.gmail.at.sichyuriyy.lab7.rsserver;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gmail.at.sichyuriyy.lab7.jpa.dao.MovieDAO;
import com.gmail.at.sichyuriyy.lab7.jpa.entities.Movie;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class MovieRS {

    @EJB 
    private MovieDAO movieDAO;
    
    @POST
    public void createMovie(Movie movie) {
        movieDAO.create(movie);
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteMovie(@PathParam("id") long id) {
        movieDAO.delete(id);
    }
    
    @PUT
    public void updateMovie(Movie movie) {
        movieDAO.update(movie);
    }
    
    @GET
    public List<Movie> getAllMovies() {
        return movieDAO.getAll();
    }
    
    @GET
    @Path("/{id}")
    public Movie getMovieById(@PathParam("id") long id) {
        return movieDAO.getById(id);
    }

    public MovieDAO getMovieDAO() {
        return movieDAO;
    }

    public void setMovieDAO(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

}

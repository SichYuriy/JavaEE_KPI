package com.gmail.at.sichyuriyy.lab5.beans;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.gmail.at.sichyuriyy.lab5.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab5.services.MovieService;
import com.gmail.at.sichyuriyy.lab5.services.MovieServiceBean;

@ManagedBean(name="movieFilter")
@SessionScoped
public class MovieFilterBean {
    
    private String nameFilter;
    
    @EJB
    private MovieService movieService;
    
    public List<Movie> getMovies() {
        
        List<Movie> result = movieService.getAll();
        if (nameFilter != null && nameFilter.trim().length() > 0) {
            result = result.stream()
                    .filter((val)->{
                        if (val.getTitle().indexOf(nameFilter) != -1) {
                            return true;
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
                    
        }
        return result;
    }

    public String getNameFilter() {
        return nameFilter;
    }

    public void setNameFilter(String nameFilter) {
        this.nameFilter = nameFilter;
    }

    public MovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceBean movieService) {
        this.movieService = movieService;
    }
}

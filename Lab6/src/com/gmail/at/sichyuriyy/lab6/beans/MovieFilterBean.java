package com.gmail.at.sichyuriyy.lab6.beans;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.gmail.at.sichyuriyy.lab6.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab6.services.MovieService;

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

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
}

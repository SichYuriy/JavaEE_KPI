package com.gmail.at.sichyuriyy.lab7.rsclient;

import javax.ejb.Stateless;

import com.gmail.at.sichyuriyy.lab7.entities.Movie;

@Stateless
public class MovieRestDAO extends RestDAO<Movie> {
    
    
    public MovieRestDAO() {
        super("http://localhost:8081/Lab7-rssserver-0.0.1-SNAPSHOT/movies");
    }
    
    

}

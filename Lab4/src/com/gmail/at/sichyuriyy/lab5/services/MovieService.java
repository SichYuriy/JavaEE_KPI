package com.gmail.at.sichyuriyy.lab5.services;

import javax.ejb.Remote;
import javax.inject.Named;

import com.gmail.at.sichyuriyy.lab5.jpa.entities.Movie;

@Named
@Remote
public interface MovieService extends ServiceCRUD<Movie> {
    

}

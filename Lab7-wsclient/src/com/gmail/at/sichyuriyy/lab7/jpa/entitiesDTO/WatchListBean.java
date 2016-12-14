package com.gmail.at.sichyuriyy.lab7.jpa.entitiesDTO;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.gmail.at.sichyuriyy.lab7.wsclient.Movie;
import com.gmail.at.sichyuriyy.lab7.wsclient.WatchList;



@ManagedBean(name="watchList")
@RequestScoped
public class WatchListBean {
	
	private long id;
	private String name;
	private List<Movie> movies;
	
	public WatchListBean() {
		
	}
	
	public WatchListBean(WatchList wl) {
		this.id = wl.getId();
		this.name = wl.getName();
		this.movies = wl.getMovies();
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	

}

package com.gmail.at.sichyuriyy.lab6.jpa.entitiesDTO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.gmail.at.sichyuriyy.lab6.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab6.jpa.entities.Rating;

@ManagedBean(name="movie")
@RequestScoped
public class MovieBean {
	
	private long id;

	private String title;
	private String description;
	private Integer duration;
	private Integer year;
	
	private long producerId;
	// addMovieToWatchList
	private long watchListId;
	
	private Rating rating;
	
	public MovieBean() {
		rating = new Rating();
	}
	
	public MovieBean(Movie movie) {
		this.producerId = movie.getProducer().getId();
		this.id = movie.getId();
		this.title = movie.getTitle();
		this.description = movie.getDescription();
		this.duration = movie.getDuration();
		this.year = movie.getYear();
		this.rating = movie.getRating();
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public long getProducerId() {
		return producerId;
	}

	public void setProducerId(long producerId) {
		this.producerId = producerId;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public long getWatchListId() {
		return watchListId;
	}

	public void setWatchListId(long watchListId) {
		this.watchListId = watchListId;
	}

	

	

}

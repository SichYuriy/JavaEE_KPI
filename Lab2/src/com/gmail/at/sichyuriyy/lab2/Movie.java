package com.gmail.at.sichyuriyy.lab2;

/**
 *
 * @author Yuriy
 */
public class Movie {

	private int id;
	private int duration;
	private int year;
	private String description;
	private String producer;
	private String name;

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getDuration() {
		return duration;
	}



	public void setDuration(int duration) {
		this.duration = duration;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getProducer() {
		return producer;
	}



	public void setProducer(String producer) {
		this.producer = producer;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public boolean equals(Object o) {
		Movie movie;
		if (o instanceof Movie) {
			movie = (Movie) o;
		} else {
			return false;
		}

		if (this.id == movie.id && this.name.equals(movie.name) && this.producer.equals(movie.producer)
				&& this.year == movie.year && this.duration == movie.duration
				&& this.description.equals(movie.description)) {
			return true;
		} else {
			return false;
		}
	}

}
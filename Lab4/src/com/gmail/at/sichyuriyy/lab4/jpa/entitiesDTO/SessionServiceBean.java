package com.gmail.at.sichyuriyy.lab4.jpa.entitiesDTO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.gmail.at.sichyuriyy.lab4.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab4.jpa.entities.Producer;
import com.gmail.at.sichyuriyy.lab4.jpa.entities.WatchList;

@ManagedBean(name="editService")
@SessionScoped
public class SessionServiceBean {
	
	private MovieBean movie;
	private ProducerBean producer;
	private WatchListBean watchList;
	
	public String editMovie(Movie movie) {
		this.movie = new MovieBean(movie);
		return "editMovie";
	}
	
	public void editProducer(Producer producer) {
		this.producer = new ProducerBean(producer);
	}
	
	public void editWatchList(WatchList list) {
		this.watchList = new WatchListBean(list);
	}

	public MovieBean getMovie() {
		return movie;
	}

	public void setMovie(MovieBean movie) {
		this.movie = movie;
	}

	public ProducerBean getProducer() {
		return producer;
	}

	public void setProducer(ProducerBean producer) {
		this.producer = producer;
	}

	public WatchListBean getWatchList() {
		return watchList;
	}

	public void setWatchList(WatchListBean watchList) {
		this.watchList = watchList;
	}
	

}
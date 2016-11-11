package com.gmail.at.sichyuriyy.lab5.jpa.entitiesDTO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.gmail.at.sichyuriyy.lab5.jpa.dao.WatchListDAO;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.Producer;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.WatchList;
import com.gmail.at.sichyuriyy.lab5.services.WatchListService;

@ManagedBean(name="editService")
@SessionScoped
public class SessionServiceBean {
    
    @EJB
    private WatchListService watchListService;
	
	private MovieBean movie;
	private ProducerBean producer;
	private WatchListBean watchList;
	
	@EJB
	private WatchListDAO watchListDAO;
	
	public String addMovieToWatchList(Movie movie) {
		this.movie = new MovieBean(movie);
		return "addMovieToWatchList";
	}
	
	public String editMovie(Movie movie) {
		this.movie = new MovieBean(movie);
		return "editMovie";
	}
	
	public String editProducer(Producer producer) {
		this.producer = new ProducerBean(producer);
		return "editProducer";
	}
	
	public String editWatchList(WatchList list) {
		this.watchList = new WatchListBean(list);
		return "editWatchList";
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
	
	public String saveMovieInWatchList(long listId, long movieId) {
	    watchListService.addMovieToWatchList(listId, movieId);
	    this.watchList = new WatchListBean(watchListDAO.getById(listId));
	    return "editWatchList";   
	}
	
	public String deleteMovieFromWatchList(long listId, long movieId) {
	    watchListService.deleteMovieFromWatchList(listId, movieId);
	    this.watchList = new WatchListBean(watchListService.getById(listId));
	    return "editWatchList";
	}

    public WatchListService getWatchListService() {
        return watchListService;
    }

    public void setWatchListService(WatchListService watchListService) {
        this.watchListService = watchListService;
    }
	
	
    
	

}

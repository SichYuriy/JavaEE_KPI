package com.gmail.at.sichyuriyy.lab7.jpa.entitiesDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;

import com.gmail.at.sichyuriyy.lab7.services.WatchListService;
import com.gmail.at.sichyuriyy.lab7.wsclient.Movie;
import com.gmail.at.sichyuriyy.lab7.wsclient.Producer;
import com.gmail.at.sichyuriyy.lab7.wsclient.WatchList;
import com.gmail.at.sichyuriyy.lab7.wsclient.WatchListImplService;
import com.gmail.at.sichyuriyy.lab7.wsclient.WatchListWS;

@ManagedBean(name = "editService")
@SessionScoped
public class SessionServiceBean {

    @EJB
    private WatchListService watchListService;

    private MovieBean movie;
    private ProducerBean producer;
    private WatchListBean watchList;

    @WebServiceRef(wsdlLocation = "http://localhost:8081/Lab7-0.0.1-SNAPSHOT/WatchListImpl?wsdl")
    private WatchListImplService watchListServiceImpl;

    private WatchListWS watchListWS;

    @PostConstruct
    protected void init() {
        watchListWS = watchListServiceImpl.getWatchListImplPort();
    }

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
        this.watchList = new WatchListBean(watchListWS.getWatchListById(listId));
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

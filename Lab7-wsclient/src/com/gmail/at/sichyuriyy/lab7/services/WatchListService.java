package com.gmail.at.sichyuriyy.lab7.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;
import javax.xml.ws.WebServiceRef;

import org.apache.log4j.Logger;

import com.gmail.at.sichyuriyy.lab7.jpa.entitiesDTO.WatchListBean;
import com.gmail.at.sichyuriyy.lab7.wsclient.Movie;
import com.gmail.at.sichyuriyy.lab7.wsclient.MovieServiceImplService;
import com.gmail.at.sichyuriyy.lab7.wsclient.MovieWS;
import com.gmail.at.sichyuriyy.lab7.wsclient.WatchList;
import com.gmail.at.sichyuriyy.lab7.wsclient.WatchListImplService;
import com.gmail.at.sichyuriyy.lab7.wsclient.WatchListWS;

@Named
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
@Stateless
public class WatchListService implements ServiceCRUD<WatchList> {
    
    private Logger logger;
    
    @WebServiceRef(wsdlLocation = "http://localhost:8081/Lab7-0.0.1-SNAPSHOT/MovieServiceImpl?wsdl")
    private MovieServiceImplService movieServiceImpl;
    @WebServiceRef(wsdlLocation = "http://localhost:8081/Lab7-0.0.1-SNAPSHOT/WatchListImpl?wsdl")
    private WatchListImplService watchListServiceImpl;

    private MovieWS movieWS;
    private WatchListWS watchListWS;

    @PostConstruct
    protected void init() {
        movieWS = movieServiceImpl.getMovieServiceImplPort();
        watchListWS = watchListServiceImpl.getWatchListImplPort();
        logger = Logger.getLogger(WatchListService.class);
    }

    @Override
    public void create(WatchList list) {
        watchListWS.create(list);
    }

    public String create(String name) {
        WatchList list = new WatchList();
        list.setName(name);

        watchListWS.create(list);
        return "watchLists";
    }

    public String create(WatchListBean list) {
        create(list.getName());
        return "watchLists";
    }

    @Override
    public void update(WatchList list) {
        watchListWS.updateWatchList(list);
    }

    public String update(long id, String name) {
        WatchList list = watchListWS.getWatchListById(id);
        list.setName(name);
        update(list);
        return "watchLists";
    }

    public String update(WatchListBean list) {
        update(list.getId(), list.getName());
        return "watchLists";
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String deleteMovieFromWatchList(long listId, long movieId) {
        WatchList watchList = watchListWS.getWatchListById(listId);
        for (Movie m : watchList.getMovies()) {
            if (m.getId() == movieId) {
                watchList.getMovies().remove(m);
                break;
            }
        }
        update(watchList);
        return "editWatchList";
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String addMovieToWatchList(long listId, long movieId) {

        WatchList wl = watchListWS.getWatchListById(listId);
        Movie m = movieWS.getMovieById(movieId);
        wl.getMovies().add(m);
        watchListWS.updateWatchList(wl);

        return "watchLists";
    }

    @Override
    public void delete(long id) {
        watchListWS.deleteWatchList(id);

    }

    @Override
    public WatchList getById(long id) {
        return watchListWS.getWatchListById(id);
    }

    @Override
    public List<WatchList> getAll() {
        logger.info("getAll");
        return watchListWS.getAllWatchLists();
    }

}

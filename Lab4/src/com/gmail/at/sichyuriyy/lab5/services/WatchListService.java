package com.gmail.at.sichyuriyy.lab5.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.gmail.at.sichyuriyy.lab5.jpa.dao.MovieDAO;
import com.gmail.at.sichyuriyy.lab5.jpa.dao.WatchListDAO;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab5.jpa.entities.WatchList;
import com.gmail.at.sichyuriyy.lab5.jpa.entitiesDTO.WatchListBean;

@Named
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
@Stateless
public class WatchListService implements ServiceCRUD<WatchList> {
    
    private Logger logger;

    @EJB
    private WatchListDAO watchListDAO;
    @EJB
    private MovieDAO movieDAO;
    
    @PostConstruct
    private void init() {
        logger = Logger.getLogger(WatchListService.class);
    }

    @Override
    public void create(WatchList list) {
        watchListDAO.create(list);
    }

    public String create(String name) {
        WatchList list = new WatchList();
        list.setName(name);

        watchListDAO.create(list);
        return "watchLists";
    }

    public String create(WatchListBean list) {
        create(list.getName());
        return "watchLists";
    }

    @Override
    public void update(WatchList list) {
        watchListDAO.update(list);
    }

    public String update(long id, String name) {
        WatchList list = watchListDAO.getById(id);
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
        WatchList watchList = watchListDAO.getById(listId);
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

        WatchList wl = watchListDAO.getById(listId);
        Movie m = movieDAO.getById(movieId);
        wl.getMovies().add(m);
        watchListDAO.update(wl);

        return "watchLists";
    }

    @Override
    public void delete(long id) {
        watchListDAO.delete(id);

    }

    @Override
    public WatchList getById(long id) {
        return watchListDAO.getById(id);
    }

    @Override
    public List<WatchList> getAll() {
        logger.info("getAll");
        return watchListDAO.getAll();
    }

}

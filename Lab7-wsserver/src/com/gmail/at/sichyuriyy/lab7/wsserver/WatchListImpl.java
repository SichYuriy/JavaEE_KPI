package com.gmail.at.sichyuriyy.lab7.wsserver;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.gmail.at.sichyuriyy.lab7.jpa.dao.WatchListDAO;
import com.gmail.at.sichyuriyy.lab7.jpa.entities.WatchList;

@Stateless
@WebService(endpointInterface = "com.gmail.at.sichyuriyy.lab7.wsserver.WatchListWS")
public class WatchListImpl implements WatchListWS {

    @EJB
    private WatchListDAO watchListDAO;
    
    @Override
    public void create(WatchList watchList) {
        watchListDAO.create(watchList);
    }

    @Override
    public void deleteWatchList(long id) {
        watchListDAO.delete(id);
    }

    @Override
    public void updateWatchList(WatchList watchList) {
        watchListDAO.update(watchList);
    }

    @Override
    public List<WatchList> getAllWatchLists() {
        return watchListDAO.getAll();
    }

    @Override
    public WatchList getWatchListById(long id) {
        return watchListDAO.getById(id);
    }
    
    

}

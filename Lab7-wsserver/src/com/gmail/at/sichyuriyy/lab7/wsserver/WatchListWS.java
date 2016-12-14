package com.gmail.at.sichyuriyy.lab7.wsserver;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.gmail.at.sichyuriyy.lab7.jpa.entities.WatchList;

@WebService
public interface WatchListWS {
    
    @WebMethod
    public void create(WatchList watchList);
    
    @WebMethod
    public void deleteWatchList(long id);
    
    @WebMethod
    public void updateWatchList(WatchList watchList);
    
    @WebMethod
    public List<WatchList> getAllWatchLists();
    
    @WebMethod
    public WatchList getWatchListById(long id);

}

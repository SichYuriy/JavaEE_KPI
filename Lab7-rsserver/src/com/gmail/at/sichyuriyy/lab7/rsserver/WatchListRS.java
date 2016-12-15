package com.gmail.at.sichyuriyy.lab7.rsserver;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gmail.at.sichyuriyy.lab7.jpa.dao.WatchListDAO;
import com.gmail.at.sichyuriyy.lab7.jpa.entities.WatchList;

@Path("watchLists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class WatchListRS {

    @EJB
    private WatchListDAO watchListDAO;
    
    @POST
    public void create(WatchList watchList) {
        watchListDAO.create(watchList);
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteWatchList(@PathParam("id") long id) {
        watchListDAO.delete(id);
    }
    
    @PUT
    public void updateWatchList(WatchList watchList) {
        watchListDAO.update(watchList);
    }
    
    @GET
    public List<WatchList> getAllWatchLists() {
        return watchListDAO.getAll();
    }
    
    @GET
    @Path("/{id}")
    public WatchList getWatchListById(@PathParam("id") long id) {
        return watchListDAO.getById(id);
    }
    
    

}

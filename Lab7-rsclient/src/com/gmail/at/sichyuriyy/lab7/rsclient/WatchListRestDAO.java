package com.gmail.at.sichyuriyy.lab7.rsclient;

import javax.ejb.Stateless;

import com.gmail.at.sichyuriyy.lab7.entities.WatchList;

@Stateless
public class WatchListRestDAO extends RestDAO<WatchList>{

    
    public WatchListRestDAO() {
        super("http://localhost:8081/Lab7-rssserver-0.0.1-SNAPSHOT/watchLists");
    }
}

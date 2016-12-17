package com.gmail.at.sichyuriyy.lab7.rsclient;

import javax.ejb.Stateless;

import com.gmail.at.sichyuriyy.lab7.entities.Producer;

@Stateless
public class ProducerRestDAO extends RestDAO<Producer> {

    public ProducerRestDAO() {
        super("http://localhost:8081/Lab7-rssserver-0.0.1-SNAPSHOT/producers");
    }

}

package com.gmail.at.sichyuriyy.lab7.rsclient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;


public class RestDAO<T> extends AbstractDAO<T> {

    protected String uri;
    
    protected RestDAO(String uri) {
        this.uri = uri;
    }

    @Override
    public void create(T obj) {
        Client client = getClient();
        client.target(uri)
                .request()
                .post(Entity.entity(obj, MediaType.APPLICATION_JSON), obj.getClass());

    }

    @Override
    public void delete(long id) {
        Client client = getClient();
        client.target(uri)
                .path("{id}")
                .resolveTemplate("id", id)
                .request()
                .delete();

    }

    @Override
    public void update(T obj) {
        Client client = getClient();
        client.target(uri)
                .request()
                .put(Entity.entity(obj, MediaType.APPLICATION_JSON), obj.getClass());

    }

    @Override
    public List<T> getAll() {
        Client client = getClient();
        List<T> clients = client.target(uri)
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<T>>(){});
        return clients;
    }

    @Override
    public T getById(long id) {
        Client client = getClient();
        client.target(uri)
                .path("{id}")
            .resolveTemplate("id", id)
            .request()
            .get();
        return null;
    }

    protected Client getClient() {
        return ClientBuilder.newClient();
    }

}

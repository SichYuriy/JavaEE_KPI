package com.gmail.at.sichyuriyy.lab4.services;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.gmail.at.sichyuriyy.lab4.jpa.dao.MovieDAO;
import com.gmail.at.sichyuriyy.lab4.jpa.dao.WatchListDAO;
import com.gmail.at.sichyuriyy.lab4.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab4.jpa.entities.WatchList;
import com.gmail.at.sichyuriyy.lab4.jpa.entitiesDTO.WatchListBean;

@ManagedBean(name="watchListService")
@ApplicationScoped
public class WatchListService implements ServiceCRUD<WatchList> {

	private WatchListDAO watchListDAO = WatchListDAO.getInstance();
	private MovieDAO movieDAO = MovieDAO.getInstance();

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

	public String deleteMovieFromWatchList(long listId, long movieId) {
		WatchList watchList = watchListDAO.getById(listId);
		for (Movie m : watchList.getMovies()) {
			if (m.getId() == movieId) {
				watchList.getMovies().remove(m);
				break;
			}
		}
		update(watchList);
		return "watchLists";
	}
	
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
		return watchListDAO.getAll();
	}

}

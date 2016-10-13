package com.gmail.at.sichyuriyy.lab3.servlets.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.at.sichyuriyy.lab3.jpa.dao.MovieDAO;
import com.gmail.at.sichyuriyy.lab3.jpa.dao.WatchListDAO;
import com.gmail.at.sichyuriyy.lab3.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab3.jpa.entities.WatchList;

/**
 * Servlet implementation class DeleteMovieServlet
 */
@WebServlet("/deleteMovie")
public class DeleteMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MovieDAO movieDAO = MovieDAO.getInstance();
	private WatchListDAO watchListDAO = WatchListDAO.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		long id = Long.parseLong(idStr);
		
		Movie movie = movieDAO.getById(id);
		
		for (WatchList list : movie.getWatchLists()) {
			list.getMovies().remove(movie);
			watchListDAO.update(list);
		}
		
		movieDAO.delete(movie);
		
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

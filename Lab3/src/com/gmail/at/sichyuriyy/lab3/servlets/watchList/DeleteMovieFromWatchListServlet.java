package com.gmail.at.sichyuriyy.lab3.servlets.watchList;

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
 * Servlet implementation class DeleteMovieFromWatchListServlet
 */
@WebServlet("/deleteMovieFromWatchList")
public class DeleteMovieFromWatchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private WatchListDAO watchListDAO = WatchListDAO.getInstance();
	private MovieDAO movieDAO = MovieDAO.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMovieFromWatchListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieIdStr = request.getParameter("movieId");
		String watchListIdStr = request.getParameter("listId");
		
		long movieId = Long.parseLong(movieIdStr);
		long watchListId = Long.parseLong(watchListIdStr);
		
		WatchList watchList = watchListDAO.getById(watchListId);
		
		for (Movie m : watchList.getMovies()) {
			if (m.getId() == movieId) {
				watchList.getMovies().remove(m);
				break;
			}
		}
		
		
		watchListDAO.update(watchList);
		
		response.sendRedirect("editList.jsp?id=" + watchListIdStr);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

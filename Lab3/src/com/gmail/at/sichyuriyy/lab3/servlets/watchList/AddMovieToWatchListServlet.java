package com.gmail.at.sichyuriyy.lab3.servlets.watchList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.at.sichyuriyy.lab3.services.WatchListService;

/**
 * Servlet implementation class AddMovieToWatchListServlet
 */
@WebServlet("/addMovieToWatchList")
public class AddMovieToWatchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private WatchListService watchListService = new WatchListService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovieToWatchListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieIdStr = request.getParameter("movieId");
		String watchListIdStr = request.getParameter("watchListId");
		
		long movieId = Long.parseLong(movieIdStr);
		long watchListId = Long.parseLong(watchListIdStr);
		
		watchListService.addMovieToWatchList(watchListId, movieId);
		
		response.sendRedirect("editList.jsp?id=" + watchListIdStr);
		
	
	}

}

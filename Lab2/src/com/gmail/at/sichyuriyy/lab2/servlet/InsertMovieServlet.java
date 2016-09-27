package com.gmail.at.sichyuriyy.lab2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.at.sichyuriyy.lab2.Dao;
import com.gmail.at.sichyuriyy.lab2.DbConnection;
import com.gmail.at.sichyuriyy.lab2.Movie;

/**
 * Servlet implementation class InsertMovieServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/postMovie" })
public class InsertMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Dao dao;
	private DbConnection dbConnection;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMovieServlet() {
        super();
        dao = new Dao();
        dbConnection = DbConnection.getInstance();
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
		try {
			String movieName = request.getParameter("movieName");
			String movieDescription = request.getParameter("movieDescription");
			String movieProducer = request.getParameter("movieProducer");
			int movieYear = Integer.parseInt(request.getParameter("movieYear"));
			int movieDuration = Integer.parseInt(request.getParameter("movieDuration"));
			Movie movie = new Movie();
			movie.setName(movieName);
			movie.setDescription(movieDescription);
			movie.setProducer(movieProducer);
			movie.setYear(movieYear);
			movie.setDuration(movieDuration);
			dao.insertMovie(dbConnection.getConnection(), movie, true);
			response.sendRedirect("index.jsp");
			
		} catch (java.lang.NumberFormatException e) {
			response.sendError(javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST, "Wrong Year or movie duration");
		}
		
		
		
	}

}

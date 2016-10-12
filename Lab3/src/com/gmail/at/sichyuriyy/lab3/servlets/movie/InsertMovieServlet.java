package com.gmail.at.sichyuriyy.lab3.servlets.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.at.sichyuriyy.lab3.jpa.dao.MovieDAO;
import com.gmail.at.sichyuriyy.lab3.jpa.dao.ProducerDAO;
import com.gmail.at.sichyuriyy.lab3.jpa.entities.Movie;
import com.gmail.at.sichyuriyy.lab3.jpa.entities.Producer;
import com.gmail.at.sichyuriyy.lab3.jpa.entities.Rating;



/**
 * Servlet implementation class InsertMovieServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/createMovie" })
public class InsertMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProducerDAO producerDAO = ProducerDAO.getInstance();
	private MovieDAO movieDAO = MovieDAO.getInstance();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMovieServlet() {
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
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int duration = Integer.parseInt(request.getParameter("duration"));
		
		double imdbRating = Double.parseDouble(request.getParameter("imdbRating"));
		double kinoPoiskRating = Double.parseDouble(request.getParameter("kinoPoiskRating"));
		double rottenTomatosRating = Double.parseDouble(request.getParameter("rottenTomatosRating"));
		
		long producerId = Long.parseLong(request.getParameter("producerId"));
		
		Movie movie = new Movie();
		
		movie.setTitle(title);
		movie.setDescription(description);
		movie.setDuration(duration);
		
		
		Rating rating = new Rating();
		
		rating.setImdbRating(imdbRating);
		rating.setKinoPoiskRating(kinoPoiskRating);
		rating.setRottenTomatosRating(rottenTomatosRating);
		
		movie.setRating(rating);
		
		Producer producer = producerDAO.getById(producerId);
		
		movie.setProducer(producer);
		//producer.getMovies().add(movie);
		
		movieDAO.create(movie);
		
		response.sendRedirect("index.jsp");
		
		
		
	}

}

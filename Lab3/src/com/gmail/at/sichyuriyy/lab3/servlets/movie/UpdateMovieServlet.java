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
 * Servlet implementation class UpdateMovieServlet
 */
@WebServlet("/updateMovie")
public class UpdateMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MovieDAO movieDAO = MovieDAO.getInstance();
	private ProducerDAO producerDAO = ProducerDAO.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMovieServlet() {
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
		String idStr = request.getParameter("id");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int duration = Integer.parseInt(request.getParameter("duration"));
		long id = Long.parseLong(idStr);
		double imdbRating = Double.parseDouble(request.getParameter("imdbRating"));
		double kinoPoiskRating = Double.parseDouble(request.getParameter("kinoPoiskRating"));
		double rottenTomatosRating = Double.parseDouble(request.getParameter("rottenTomatosRating"));
		
		long producerId = Long.parseLong(request.getParameter("producerId"));
		
		Movie movie = movieDAO.getById(id);
		
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
		
		movieDAO.update(movie);
		
		response.sendRedirect("index.jsp");
	}

}

package lection.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lection.entities.Movie;
import lection.entities.Rating;
import lection.services.MovieService;


/**
 * Servlet implementation class createMovieServlet
 */
@WebServlet("/createMovie")
public class createMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MovieService service = new MovieService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		Rating rating = new Rating();
		rating.setImdbRating(imdbRating);
		rating.setKinoPoiskRating(kinoPoiskRating);
		rating.setRottenTomatosRating(rottenTomatosRating);
		
		Movie movie = new Movie();
		movie.setDescription(description);
		movie.setDuration(duration);
		movie.setTitle(title);
		movie.setRating(rating);
		
		rating.setMovie(movie);
		
		service.createMovie(movie);
		
		response.sendRedirect("index.jsp");
	}

}

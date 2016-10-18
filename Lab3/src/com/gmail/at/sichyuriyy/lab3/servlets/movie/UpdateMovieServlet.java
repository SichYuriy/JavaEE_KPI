package com.gmail.at.sichyuriyy.lab3.servlets.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.at.sichyuriyy.lab3.services.MovieService;

/**
 * Servlet implementation class UpdateMovieServlet
 */
@WebServlet("/updateMovie")
public class UpdateMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MovieService movieService = new MovieService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMovieServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int duration = Integer.parseInt(request.getParameter("duration"));
		int year = Integer.parseInt(request.getParameter("year"));
		long movieId = Long.parseLong(idStr);
		double imdbRating = Double.parseDouble(request.getParameter("imdbRating"));
		double kinoPoiskRating = Double.parseDouble(request.getParameter("kinoPoiskRating"));
		double rottenTomatosRating = Double.parseDouble(request.getParameter("rottenTomatosRating"));

		long producerId = Long.parseLong(request.getParameter("producerId"));

		movieService.update(movieId, producerId, title, year, duration, description, imdbRating, kinoPoiskRating,
				rottenTomatosRating);

		response.sendRedirect("index.jsp");
	}

}

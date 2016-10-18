package com.gmail.at.sichyuriyy.lab3.servlets.watchList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.at.sichyuriyy.lab3.services.WatchListService;

/**
 * Servlet implementation class InsertWatchListServlet
 */
@WebServlet("/insertWatchList")
public class InsertWatchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private WatchListService watchListService = new WatchListService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertWatchListServlet() {
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
		String name = request.getParameter("name");
		
		watchListService.create(name);
		
		response.sendRedirect("watchLists.jsp");
	}

}

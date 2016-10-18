package com.gmail.at.sichyuriyy.lab3.servlets.watchList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.at.sichyuriyy.lab3.services.WatchListService;

/**
 * Servlet implementation class DeleteWatchListServlet
 */
@WebServlet("/deleteWatchList")
public class DeleteWatchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private WatchListService watchListService = new WatchListService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWatchListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String watchListIdStr = request.getParameter("id");
		
		long id = Long.parseLong(watchListIdStr);
		
		watchListService.delete(id);
		
		response.sendRedirect("watchLists.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

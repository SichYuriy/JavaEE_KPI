package com.gmail.at.sichyuriyy.lab3.servlets.producer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.at.sichyuriyy.lab3.services.ProducerService;

/**
 * Servlet implementation class UpdateProducer
 */
@WebServlet("/updateProducer")
public class UpdateProducerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProducerService producerService = new ProducerService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProducerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		long id = Long.parseLong(idStr);
		
		producerService.update(id, firstName, lastName);
		
		response.sendRedirect("producers.jsp");
	}

}

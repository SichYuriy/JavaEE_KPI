package com.gmail.at.sichyuriyy.lab3.servlets.producer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.at.sichyuriyy.lab3.jpa.dao.ProducerDAO;
import com.gmail.at.sichyuriyy.lab3.jpa.entities.Producer;

/**
 * Servlet implementation class InsertProducerServlet
 */
@WebServlet("/createProducer")
public class InsertProducerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProducerServlet() {
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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Producer producer = new Producer();
		producer.setFirstName(firstName);
		producer.setLastName(lastName);
		
		ProducerDAO dao = ProducerDAO.getInstance();
		dao.create(producer);
		
		
		response.sendRedirect("producers.jsp");
	}

}

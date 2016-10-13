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
 * Servlet implementation class DeleteProducerServlet
 */
@WebServlet("/deleteProducer")
public class DeleteProducerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProducerDAO dao = ProducerDAO.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProducerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));

		Producer p = dao.getById(id);
		dao.delete(p);

		response.sendRedirect("producers.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

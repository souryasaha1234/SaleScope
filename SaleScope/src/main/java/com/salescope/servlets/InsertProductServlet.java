package com.salescope.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.salescope.factory.OperationServiceFactory;
import com.salescope.service.OperationService;

/**
 * Servlet implementation class InsertProductServlet
 */
@WebServlet("/InsertProductServlet")
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("username");
		String pdtName = request.getParameter("pdtname");
		
		OperationService opService = OperationServiceFactory.getOperationServiceObject();
		String status = opService.InsertNewProductService(pdtName, uname);
		
		if(status.equalsIgnoreCase("success")) {
			request.setAttribute("message", "success");
			RequestDispatcher rd = request.getRequestDispatcher("insertproduct");
			rd.forward(request, response);
		}
		if(status.equalsIgnoreCase("failed")) {
			request.setAttribute("message", "failed");
			RequestDispatcher rd = request.getRequestDispatcher("insertproduct");
			rd.forward(request, response);
		}
		if(status.equalsIgnoreCase("error")) {
			request.setAttribute("message", "error");
			RequestDispatcher rd = request.getRequestDispatcher("insertproduct");
			rd.forward(request, response);
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}

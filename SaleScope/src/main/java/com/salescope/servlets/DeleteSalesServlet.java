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
 * Servlet implementation class DeleteSalesServlet
 */
@WebServlet("/DeleteSalesServlet")
public class DeleteSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("username");
		
		String salesId = request.getParameter("salesId");
		String pdtSelect = request.getParameter("pdtSelect");
		
		System.out.println("servlet-"+pdtSelect+" "+salesId);
		
		OperationService opService = OperationServiceFactory.getOperationServiceObject();
		String status = opService.DeleteSalesService(pdtSelect, salesId, uname);
		
		if(status.equalsIgnoreCase("success")) {
			request.setAttribute("message", "success");
			RequestDispatcher rd = request.getRequestDispatcher("getProductServlet?desturl=deleteSales");
			rd.forward(request, response);
		}
		else if(status.equalsIgnoreCase("failed")) {
			request.setAttribute("message", "failed");
			RequestDispatcher rd = request.getRequestDispatcher("getProductServlet?desturl=deleteSales");
			rd.forward(request, response);
		}
		else if(status.equalsIgnoreCase("error")) {
			request.setAttribute("message", "error");
			RequestDispatcher rd = request.getRequestDispatcher("getProductServlet?desturl=deleteSales");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

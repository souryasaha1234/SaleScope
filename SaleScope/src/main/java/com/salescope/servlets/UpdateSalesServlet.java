package com.salescope.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateSalesServlet
 */
@WebServlet("/UpdateSalesServlet")
public class UpdateSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pdtName = request.getParameter("pdt");
		String salesId = request.getParameter("salesId");
		String costPrice = request.getParameter("costPrice");
		String sellPrice = request.getParameter("sellPrice");
		String purchaseQty = request.getParameter("purchaseQty");
		String sellQty = request.getParameter("sellQty");
		String purchaseDate = request.getParameter("purchaseDate");
		String sellDate = request.getParameter("sellDate");
		System.out.println("=====================");
		System.out.println(pdtName);
		System.out.println(salesId);
		System.out.println(costPrice);
		System.out.println(sellPrice);
		System.out.println(purchaseQty);
		System.out.println(sellQty);
		System.out.println(purchaseDate);
		System.out.println(sellDate);
		System.out.println("=====================");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
}

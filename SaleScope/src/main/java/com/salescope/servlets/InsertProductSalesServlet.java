package com.salescope.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.salescope.bean.Product;
import com.salescope.factory.OperationServiceFactory;
import com.salescope.service.OperationService;

/**
 * Servlet implementation class InsertProductSalesServlet
 */
@WebServlet("/InsertProductSalesServlet")
public class InsertProductSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("username");
		
		String pdtSelect = request.getParameter("pdtSelect");
		String costPrice = request.getParameter("costPrice");
		String sellPrice = request.getParameter("sellPrice");
		String purchaseQty = request.getParameter("purchaseQty");
		String sellQty = request.getParameter("sellQty");
		String purchaseDate = request.getParameter("purchaseDate");
		String sellDate = request.getParameter("sellDate");
		
		Product pdt = new Product();
		pdt.setPdtSelect(pdtSelect);
		pdt.setCostPrice(costPrice);
		pdt.setSellPrice(sellPrice);
		pdt.setPurchaseQty(purchaseQty);
		pdt.setSellQty(sellQty);
		pdt.setPurchaseDate(purchaseDate);
		pdt.setSellDate(sellDate);
		
		OperationService opService = OperationServiceFactory.getOperationServiceObject();
		String status = opService.InsertProductSalesService(pdt, uname);
		
		if(status.equalsIgnoreCase("success")) {
			request.setAttribute("message", "success");
			RequestDispatcher rd = request.getRequestDispatcher("getProductServlet?desturl=insertProductSales");
			rd.forward(request, response);
		}
		else if(status.equalsIgnoreCase("failed")) {
			request.setAttribute("message", "failed");
			RequestDispatcher rd = request.getRequestDispatcher("getProductServlet?desturl=insertProductSales");
			rd.forward(request, response);
		}
		else if(status.equalsIgnoreCase("error")) {
			request.setAttribute("message", "error");
			RequestDispatcher rd = request.getRequestDispatcher("getProductServlet?desturl=insertProductSales");
			rd.forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}

package com.salescope.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.salescope.bean.ProductList;
import com.salescope.factory.OperationServiceFactory;
import com.salescope.service.OperationService;

/**
 * Servlet implementation class getProductServlet
 */
@WebServlet("/getProductServlet")
public class getProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destURL = request.getParameter("desturl");
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("username");
		System.out.println("getProductServlet.doGet()");
		OperationService opservice = OperationServiceFactory.getOperationServiceObject();
		ProductList[] pdtlt = opservice.getProductListService(uname);
		
		if(pdtlt != null) {
			request.setAttribute("productList", pdtlt);
		}
		RequestDispatcher rd = request.getRequestDispatcher(destURL);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

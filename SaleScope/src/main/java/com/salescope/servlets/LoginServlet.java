package com.salescope.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.salescope.bean.Accounts;
import com.salescope.factory.AccountsServiceFactory;
import com.salescope.service.AccountsService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html");
		
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String upassword = request.getParameter("upassword");
		String messegeLogIn = null;
		
		Accounts acc =  new Accounts();
		acc.setUname(uname);
		acc.setUemail(uemail);
		acc.setPass(upassword);
		
		AccountsService accountsService = AccountsServiceFactory.getAccountsServiceObject();
		
		String status = accountsService.loginService(acc);
		System.out.println("In login servlet");
//		if (uname.equals("aaa") && upassword.equals("bbb")) {
		if (status.equalsIgnoreCase("success")) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("homepage");
		}
		else {
			if(status.equals("failure"))
				messegeLogIn = "Username or password wrong";
			else if(status.equals("NotExisted"))
				messegeLogIn = "Account does not exist";
			else
				messegeLogIn = "Some Error occoured";
			request.setAttribute("messegeLogIn", messegeLogIn);
			request.setAttribute("messegeSignUp", null);
			request.setAttribute("username", uname);
			request.setAttribute("email", uemail);
			request.setAttribute("password", upassword);
			RequestDispatcher rd = request.getRequestDispatcher("login");
			rd.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}

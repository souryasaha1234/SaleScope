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
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String upassword = request.getParameter("upassword");
		String cnfpassword = request.getParameter("cnfpassword");
		String messegeSignUp = null;
		
		if(upassword.equals(cnfpassword)) {
			Accounts acc =  new Accounts();
			acc.setUname(uname);
			acc.setUemail(uemail);
			acc.setPass(upassword);
			
			AccountsService accountsService = AccountsServiceFactory.getAccountsServiceObject();
			String status = accountsService.signupService(acc);
			System.out.println(status);
			if(status.equalsIgnoreCase("success")) {
				System.out.println("Account inserted succesfully");
				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				response.sendRedirect("homepage");
			}			
			else if(status.equalsIgnoreCase("DuplicateUname")) {
				messegeSignUp = "Username already existed";
				request.setAttribute("messegeSignUp", messegeSignUp);
				request.setAttribute("messegeLogIn", null);
				request.setAttribute("username", uname);
				request.setAttribute("email", uemail);
				request.setAttribute("password", upassword);
				RequestDispatcher rd = request.getRequestDispatcher("login");
				rd.forward(request, response);				
			}
			else if(status.equalsIgnoreCase("failure")) {
				System.out.println("Account insertion failed - duplicate email adress");
				messegeSignUp = "Email adress already existed";
				request.setAttribute("messegeSignUp", messegeSignUp);
				request.setAttribute("messegeLogIn", null);
				request.setAttribute("username", uname);
				request.setAttribute("email", uemail);
				request.setAttribute("password", upassword);
				RequestDispatcher rd = request.getRequestDispatcher("login");
				rd.forward(request, response);
			}
			else {
				System.out.println("Account insertion failed - Error occoured");
				messegeSignUp = "Some Error occoured";
				request.setAttribute("messegeSignUp", messegeSignUp);
				request.setAttribute("messegeLogIn", null);
				request.setAttribute("username", uname);
				request.setAttribute("email", uemail);
				request.setAttribute("password", upassword);
				RequestDispatcher rd = request.getRequestDispatcher("login");
				rd.forward(request, response);
			}
		}
		else {
			System.out.println("confirm password not matched");
			messegeSignUp = "Confirm password is not matched";
			request.setAttribute("messegeSignUp", messegeSignUp);
			request.setAttribute("messegeLogIn", null);
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

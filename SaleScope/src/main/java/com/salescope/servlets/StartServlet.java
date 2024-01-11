package com.salescope.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.salescope.factory.ConnectionFactory;

/**
 * Servlet implementation class StartServlet
 */
@WebServlet(value = "/StartServlet", loadOnStartup = 1)
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con = null;
	
	@Override
	public void init() throws ServletException {
		try {
			con = ConnectionFactory.getConnectionObject();
			if(con != null)
				System.out.println("Connection Established");
			else
				System.out.println("Connection not Established");
		} catch (Exception e) {
			// e.printStackTrace();
			throw new ServletException("Exception in init() "+getClass().getName(), e);
		}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		resp.sendRedirect("homepage");
	}
}

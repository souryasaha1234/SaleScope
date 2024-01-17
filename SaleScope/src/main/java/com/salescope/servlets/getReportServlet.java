package com.salescope.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.salescope.bean.PnLStruct;
import com.salescope.bean.Report;
import com.salescope.factory.OperationServiceFactory;
import com.salescope.service.OperationService;

/**
 * Servlet implementation class getReportServlet
 */
@WebServlet("/getReportServlet")
public class getReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gotourl = request.getParameter("gotourl");
		
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("username");
		
		String pdtSelect = request.getParameter("pdtSelect");
		
		System.out.println("getReportServlet.doPostt()");
		
		OperationService opservice = OperationServiceFactory.getOperationServiceObject();
		Report[] reportArr = opservice.getSalesReportService(uname, pdtSelect);
		
		if(reportArr != null) {
			request.setAttribute("salesReport", reportArr);
		}
		
		if(gotourl.equalsIgnoreCase("displayReport")) {
			PnLStruct pls = opservice.getPLReportService(uname, pdtSelect);
			request.setAttribute("pnlrep", pls);
//			request.setAttribute("daily", pls.getDaily());
//			request.setAttribute("monthly", pls.getMonthly());
//			request.setAttribute("yearly", pls.getYearly());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("getProductServlet?desturl="+gotourl);
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getReportServlet.doGet()");
		doPost(request, response);
	}

}

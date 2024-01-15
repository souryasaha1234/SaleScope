<%@page import="com.salescope.bean.Report"%>
<%@page import="com.salescope.bean.ProductList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Sales</title>
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/tablestyle.css">
    <link rel="stylesheet" href="styles/messeges.css">
</head>
<body>
   	<%
		//preventing back button after logout
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0"); //proxies
   		
		String welcome = null;
		ProductList[] pdtlt = null;
		Report[] reportArr = null;

		//User verification
   		if(session.getAttribute("username") == null){
   			response.sendRedirect("login");
   		}
		else {
			pdtlt = (ProductList[]) request.getAttribute("productList");
			reportArr = (Report[]) request.getAttribute("salesReport");
			welcome = "<p class='welcome-message'>Welcome <b style='color: red;'>"+session.getAttribute("username")+"</b>!</p>";
		}
		
   	%>
     <header>
         <div id="topHead">
             <a href="homepage">
                 <img src="resources/img/SaleScope-logos_white.png" />
             </a>
			<a id="logout" class="logs" href="logout">LogOut</a>
			<%= welcome %>
         </div>
         <h1>SaleScope</h1>
         <h3>-: <u>All-in-one Sales Report</u> :-</h3>
     </header>

	<form action="getReportServlet?gotourl=updateSales" method="POST" class="userInputForm">
        <table>
            <tr>
                <td>Select product </td>
                <td>
                <select name="pdtSelect">                
					<option value="--select--">--Select--</option>
					<option value="ALL">ALL</option>
                <c:forEach items="<%=pdtlt%>" var="pdt">
					<option value="${pdt.getPdtId() }_${pdt.getPdtName() }">${pdt.getPdtId() }--${pdt.getPdtName() }</option>
                </c:forEach>
				</select>
				</td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Show Report</button></td>
            </tr>
        </table>
    </form>
    

	<table id="reportTable">
		<tr>
			<th>Product</th>
			<th>Sales Id</th>
			<th>Cost Price</th>
			<th>Sell Price</th>
			<th>Purchase Qty.</th>
			<th>Sell Qty.</th>
			<th>Total Purchase</th>
			<th>Total Sell</th>
			<th>Net Profit</th>
			<th>Purchase Date</th>
			<th>Sell Date</th>
			<th>###</th>
	    </tr>
      	<c:forEach items="<%=reportArr%>" var="rpt">
		    <tr>
		      	<td>${rpt.getPdtSelect() }</td>
		      	<td>${rpt.getSalesId() }</td>
		      	<td>${rpt.getCostPrice() }</td>
		      	<td>${rpt.getSellPrice() }</td>
		      	<td>${rpt.getPurchaseQty() }</td>
		      	<td>${rpt.getSellQty() }</td>

		      	<td>${rpt.getTotalPurchase() }</td>
		      	<td>${rpt.getTotalSell() }</td>
		      	<td>${rpt.getNetProfit() }</td>
		      	
		      	<td>${rpt.getPurchaseDate() }</td>
		      	<td>${rpt.getSellDate() }</td>

		      	<td><a href="UpdateSalesFormPage?pdt=${rpt.getPdtSelect() }&salesId=${rpt.getSalesId() }
		      				&costPrice=${rpt.getCostPrice() }&sellPrice=${rpt.getSellPrice() }&purchaseQty=${rpt.getPurchaseQty() }
		      				&sellQty=${rpt.getSellQty() }&purchaseDate=${rpt.getPurchaseDate() }&sellDate=${rpt.getSellDate() }" 
		      				class="updateBtn">Update</a></td>
		    </tr>
		</c:forEach>
	</table>

	
    <footer>
	    <a href="homepage"
	        ><img
	            src="resources/img/SaleScope-logos_transparent.png"
	            id="logo_footer"
	            height="150px"
	    /></a>
	    <p>Copyright &copy 2024 SaleScope India</p>
	    <h1>
	        <a href="#" target="_blank"><i class="bi bi-facebook"></i></a>
	        <a href="#" target="_blank"><i class="bi bi-instagram"></i></a>
	        <a href="#" target="_blank"><i class="bi bi-twitter"></i></a>
	        <a href="#" target="_blank"><i class="bi bi-linkedin"></i></a>
	        <a href="#" target="_blank"><i class="bi bi-google"></i></a>
	        <a href="#" target="_blank"><i class="bi bi-github"></i></a>
	    </h1>
	    <p>All rights are reserved</p>
	    <p>Developed & Maintained by-@Sourya Saha</p>
	    <br />
	</footer>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
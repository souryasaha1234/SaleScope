<%@page import="com.salescope.bean.ProductList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert Product Sales</title>
<link rel="stylesheet" href="styles/style.css">
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
		//User verification
   		if(session.getAttribute("username") == null){
   			response.sendRedirect("login");
   		}
		else {
			pdtlt = (ProductList[]) request.getAttribute("productList");
			welcome = "<p class='welcome-message'>Welcome <b style='color: red;'>"+session.getAttribute("username")+"</b>!</p>";
		}
		/*
		*/
		String msg = "";
		if (request.getAttribute("message") != null){
			if (request.getAttribute("message").equals("success"))
				msg = "<div class='success-msg'><i class='fa fa-check'></i>Sales inserted successfully...!</div>";
			else if (request.getAttribute("message").equals("failed"))
				msg = "<div class='warning-msg'><i class='fa fa-warning'></i>Sales insertion failed...!</div>";
			else if (request.getAttribute("message").equals("error"))
				msg = "<div class='error-msg'><i class='fa fa-times-circle'></i>Some error occoured...!</div>";
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

	<%= msg %>
	
    <form action="InsertProductSalesServlet" method="POST" class="userInputForm">
        <table>
            <tr>
                <td colspan="2" class="formhead">Insert Product Sales</td>
            </tr>
            <tr>
                <td>Select product </td>
                <td>
                <select name="pdtSelect">                
					<option value="--select--">--Select--</option>
                <c:forEach items="<%=pdtlt%>" var="pdt">
					<option value="${pdt.getPdtId() }_${pdt.getPdtName() }">${pdt.getPdtId() }--${pdt.getPdtName() }</option>
                </c:forEach>
				</select>
				</td>
            </tr>
            <tr>
                <td>Cost price/product: </td>
                <td><input type="number" name="costPrice" placeholder="Cost Price" required></td>
            </tr>
            <tr>
                <td>Sell price/product: </td>
                <td><input type="number" name="sellPrice" placeholder="Sell Price" required></td>
            </tr>
            <tr>
                <td>Purchase quantity: </td>
                <td><input type="number" name="purchaseQty" placeholder="Purchase Quantity" required></td>
            </tr>
            <tr>
                <td>Sell quantity: </td>
                <td><input type="number" name="sellQty" placeholder="Sell Quantity" required></td>
            </tr>
            <tr>
                <td>Date of purchase: </td>
                <td><input type="date" name="purchaseDate" placeholder="Purchase date" required></td>
            </tr>
            <tr>
                <td>Date of Sell: </td>
                <td><input type="date" name="sellDate" placeholder="Sell date" required></td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Insert</button></td>
            </tr>
        </table>
    </form>
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
</body>
</html>
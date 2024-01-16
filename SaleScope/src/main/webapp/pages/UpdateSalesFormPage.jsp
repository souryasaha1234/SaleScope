<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Sales Form</title>
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
		
		//User verification
   		if(session.getAttribute("username") == null){
   			response.sendRedirect("login");
   		}
		else {
			welcome = "<p class='welcome-message'>Welcome <b style='color: red;'>"+session.getAttribute("username")+"</b>!</p>";
		}
		/*
		*/
		String msg = "";
		if (request.getAttribute("message") != null){
			if (request.getAttribute("message").equals("success"))
				msg = "<div class='success-msg'><i class='fa fa-check'></i>Product inserted successfully...!</div>";
			else if (request.getAttribute("message").equals("failed"))
				msg = "<div class='warning-msg'><i class='fa fa-warning'></i>Product insertion failed...!</div>";
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
	
    <form action="UpdateSalesServlet" method="POST" class="userInputForm">
        <table>
            <tr>
                <td colspan="2" class="formhead">Update Sales</td>
            </tr>
            <tr>
                <td>Product Name: </td>
                <td><input type="text" name="pdtname" value="<%=request.getParameter("pdt") %>" readonly></td>
            </tr>
            <tr>
                <td>Sales Id: </td>
                <td><input type="text" name="salesId" value="<%=request.getParameter("salesId") %>" readonly></td>
            </tr>
            <tr>
                <td>Cost price/product: </td>
                <td><input type="number" name="costPrice" value="<%=request.getParameter("costPrice") %>" required></td>
            </tr>
            <tr>
                <td>Sell price/product: </td>
                <td><input type="number" name="sellPrice" value="<%=request.getParameter("sellPrice") %>" required></td>
            </tr>
            <tr>
                <td>Purchase quantity: </td>
                <td><input type="number" name="purchaseQty" value="<%=request.getParameter("purchaseQty") %>" required></td>
            </tr>
            <tr>
                <td>Sell quantity: </td>
                <td><input type="number" name="sellQty" value="<%=request.getParameter("sellQty") %>" required></td>
            </tr>
            <tr>
                <td>Date of purchase: </td>
                <td><input type="date" name="purchaseDate" value="<%=request.getParameter("purchaseDate") %>" required></td>
            </tr>
            <tr>
                <td>Date of Sell: </td>
                <td><input type="date" name="sellDate" value="<%=request.getParameter("sellDate") %>" required></td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Update</button></td>
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
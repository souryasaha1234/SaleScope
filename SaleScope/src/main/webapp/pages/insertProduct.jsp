<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert Product</title>
    <link rel="stylesheet" href="styles/style.css">
</head>
<body>
   	<%
		//preventing back button after logout
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0"); //proxies
   		
		//User verification
   		if(session.getAttribute("username") == null){
   			response.sendRedirect("login");
   		}
   	%>
     <header>
         <div id="topHead">
             <a href="homepage">
                 <img src="resources/img/SaleScope-logos_white.png" />
             </a>
			<a id="logout" class="logs" href="logout">LogOut</a>
         </div>
         <h1>SaleScope</h1>
         <h3>-: <u>All-in-one Sales Report</u> :-</h3>
     </header>

    <form action="#" method="POST" class="userInputForm">
        <table>
            <tr>
                <td colspan="2" class="formhead">Insert New Product</td>
            </tr>
            <tr>
                <td>Product Name: </td>
                <td><input type="text" placeholder="Product name"></td>
            </tr>
        </table>
    </form>
</body>
</html>
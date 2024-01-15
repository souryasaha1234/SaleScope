<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Home | Sales Report</title>
        <link rel="stylesheet" href="styles/style.css" />
    </head>
    <body>
        	<%
        		//preventing back button after logout
        		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        		response.setHeader("Expires", "0"); //proxies
        	
        		String log = null;
        		String insertNewPdtLink = null;
        		String insertNewPdtSalesLink = null;
        		String DisplaySalesReportLink = null;
        		String UpdateSalesLink = null;
        		String welcome = "";
        		//User verification
        		if(session.getAttribute("username") == null){
        			log = "<a id='login' class='logs' href='login'>LogIn</a>";
        			insertNewPdtLink = "href='login'";
        			insertNewPdtSalesLink = "href='login'";
        			DisplaySalesReportLink = "href='login'";
        			UpdateSalesLink = "href='login'";
        		}
        		else{
        			//authorized user
        			log = "<a id='logout' class='logs' href='logout'>LogOut</a>";
        			insertNewPdtLink = "href='insertproduct'";
        			insertNewPdtSalesLink = "href='getProductServlet?desturl=insertProductSales'";
        			DisplaySalesReportLink = "href='getProductServlet?desturl=displayReport'";
        			UpdateSalesLink = "href='getProductServlet?desturl=updateSales'";
        			welcome = "<p class='welcome-message'>Welcome <b style='color: red;'>"+session.getAttribute("username")+"</b>!</p>";
        		}
        	%>
        <header>
            <div id="topHead">
                <a href="homepage">
                    <img src="resources/img/SaleScope-logos_white.png" />
                </a>
                <%= welcome %>
                <%= log %>
            </div>
            <h1>SaleScope</h1>
            <h3>-: <u>All-in-one Sales Report</u> :-</h3>
        </header>

        <div class="container">
            <h2>Operations</h2>
            <div class="ag-operations_box">
                <div class="ag-operations_item">
                    <div class="ag-operations-item_link">
                        <div class="ag-operations-item_bg"></div>

                        <div class="ag-operations-item_title">
                            Insert new Product
                        </div>

                        <div class="ag-operations-item_date-box">
                            <i class="bi bi-arrow-right"></i>
                            <a
                                <%= insertNewPdtLink %>
                                class="ag-operations-item_date"
                            >
                                Insert
                            </a>
                        </div>
                    </div>
                </div>

                <div class="ag-operations_item">
                    <div class="ag-operations-item_link">
                        <div class="ag-operations-item_bg"></div>

                        <div class="ag-operations-item_title">
                            Insert Product Sales
                        </div>

                        <div class="ag-operations-item_date-box">
                            <i class="bi bi-arrow-right"></i>
                            <a  
                               <%= insertNewPdtSalesLink %>
                               class="ag-operations-item_date">
                                Insert
                            </a>
                        </div>
                    </div>
                </div>

                <div class="ag-operations_item">
                    <div class="ag-operations-item_link">
                        <div class="ag-operations-item_bg"></div>

                        <div class="ag-operations-item_title">
                            Display detailed Sales Report
                        </div>

                        <div class="ag-operations-item_date-box">
                            <i class="bi bi-arrow-right"></i>
                            <a 
                            	<%= DisplaySalesReportLink %>
                            	class="ag-operations-item_date">
                                Display
                            </a>
                        </div>
                    </div>
                </div>

                <div class="ag-operations_item">
                    <div class="ag-operations-item_link">
                        <div class="ag-operations-item_bg"></div>

                        <div class="ag-operations-item_title">
                            Update Product's Sales
                        </div>

                        <div class="ag-operations-item_date-box">
                            <i class="bi bi-arrow-right"></i>
                            <a 
                            	<%= UpdateSalesLink %>
                            	class="ag-operations-item_date">
                                Update
                            </a>
                        </div>
                    </div>
                </div>

                <div class="ag-operations_item">
                    <div class="ag-operations-item_link">
                        <div class="ag-operations-item_bg"></div>

                        <div class="ag-operations-item_title">
                            Delete Product's Sales
                        </div>

                        <div class="ag-operations-item_date-box">
                            <i class="bi bi-arrow-right"></i>
                            <a href="" class="ag-operations-item_date">
                                Delete
                            </a>
                        </div>
                    </div>
                </div>

                <div class="ag-operations_item">
                    <div class="ag-operations-item_link">
                        <div class="ag-operations-item_bg"></div>

                        <div class="ag-operations-item_title">
                            Help/query or feedback on sales report
                        </div>

                        <div class="ag-operations-item_date-box">
                            <i class="bi bi-arrow-right"></i>
                            <a href="" class="ag-operations-item_date">
                                Proceed
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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
        <script src="scripts/script.js"></script>
    </body>
</html>
    
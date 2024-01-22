# SaleScope

Sales Report Web-App

# Features Offerred :-

I have designed a Sales report operations and visulalization application for user.

**We have also added an unique feature which is a LOGIN page**

      Any user can create his/her account with our web app and do any operations and visulalization.
      All the credentials and their products and corresponding sales will be saved securely and when the user again logins into our app they can retrive and edit those details.

---

## Building Blocks of the Website

SaleScope is a JAVA based Web-App for some sales report operaions.

## Technologies and Languages Used in this Website

      1) HTML
      2) CSS
      3) JAVASCRIPT
      4) JAVA SERVELET
      5) JSP
      6) JDBC
      7) MySQL

---

## Java Code Structure :-

      We have 5 packages in the Java Resources(src/main/java/)

      1) com.salescope.bean -> It contains 3 classes
            a) Accounts.class -> Contains Accounts class of user i.e, uname, uemail, pass;
            b) PnLStruct.class -> Contains Profit & Loss Structure class of sales i.e, pdtName, daily, monthly, yearly;
            c) Product.class -> Contains Product class of a user i.e, pdtSelect,  costPrice,  sellPrice,   purchaseQty,  sellQty,  purchaseDate,  sellDate;
            c) ProductList.class -> Contains ProductList class of products i.e, pdtId, pdtName;
            c) Report.class -> Contains Report class of sales i.e, pdtSelect, salesId, costPrice, sellPrice, purchaseQty, sellQty, totalPurchase, totalSell, netProfit, purchaseDate, sellDate;

      2) com.salescope.dao -> This is a DAO layer which is used for accessing or gaining connection with the Database(for Database Connectivity). This Layer contains 8 Interfaces containing Login and Sign-up for the User; insert product; insert, delete, update and view of product sales. This layer also contains the Implementation Classes which implements all methods of the DAO Interfaces.

      3) com.salescope.service -> This is a Service which is used for establishing communication between the Servlets and the DAO layer. This layer contains Interfaces and Implementation classes of it. The Interfaces contains the methods which is used for communicating between the DAO layer and Servlet layer and the Implementation classes contains the Implementation of the Interface methods.

      4) com.salescope.factory -> This a factory layer which contains all the Factory Classes used for establishing Connection with the Database and for Object Creation of Service and DAO layers.
      It contains 11 classes
            a) AccountsDaoFactory.class,
               DeleteSalesDaoFactory.class,
               UpdateSalesDaoFactory.class,
               InsertProductSalesDaoFactory.class,
               InsertNewProductDaoFactory.class,
               GetReportDaoFactory.class,
               GetProductListDaoFactory.class,
               GetPnLReportDaoFactory.class,
               DeleteSalesDaoFactory.class  -> Used for Creating Object of the DAO layer.
            b) AccountsServiceFactory.class,
               OperationServiceFactory.class -> Used for Creating Object of the Service Layer.
            c) ConnectionFactory.class -> Used for Creating the Connection with the Database and Generating the Connection Object which will be used by the DAO layer for communication with the Database.

      5) com.salescope.servlets -> This Package Contains all the Servlets to be used in the Application. There are total of 10 Servlets in the Application.
            a) StartServlet -> This is the StartUp Servlet which Starts the Application by Establishing the Connection with the Database and Generating the Connection Object.
            b) SignUpServlet -> This Servlet is called when the user wants to Sign-up. This Servlet Creates an User Account (If the details are properly entered) in the database.
            c) LogInServlet -> This Servlet Logs in to the user account iff the account exists and the user credentials are entered correctly.
            d) LogOutServlet -> This Servlet is used for Logging Out from the Application.
            e) InsertProductServlet -> This Servlet is used for inserting new product.
            f) InsertProductSalesServlet -> This Servlet is used for inserting new product sales of a product.
            g) getReportServlet -> This Servlet is used to get report of sales.
            h) getProductServlet -> This Servlet is used to get product.
            i) DeleteSalesServlet -> This Servlet is used to delete sales of a product.
            j) UpdateSalesServlet -> This Servlet is used to update sales of a product.

---

## HTML/CSS/JS/JSP Directory Structure

      Inside the Webapp Folder we have all the JSP, CSS, JS files.
      pages-> a) index.jsp -> This is the HomePage or the index page of the Application .
              b) login.jsp -> This is the Login and Sign-Up page where the user can Login / Sign-up in thier accounts.
              c) insertProduct.jsp -> This is the page to insert new product.
              d) insertProductSales.jsp -> This is the page to insert new product.
              e) displayReport.jsp -> This is the page to display the sales Report.
              f) updateSales.jsp -> This is the page to update the sales of the product.
              g) UpdateSalesFormPage.jsp -> This is the page to get user input to update the sales of the product.
              h) deleteSales.jsp -> This is the page to delete the sales of the product.

      style -> style.css,
               loginStyle.js,
               messeges.js,
               tablestyle.js -> Contains all the Scripts of the application.

      script -> script.js -> Contains all the Scripts of the application.
      resources -> img -> Contains all the images of the application.

---

## WEB-INF Folder

      In this folder we have our web.xml file which contains the URL configurations of all the jsp files and Servlets. It also contains all the Welcome file configurations of the application.

---

## Running the Application

      1) Clone the application from the Git Repository.
      2) Ensure these following softwares are installed prior running :
            a) Eclipse IDE
            b) Tomcat Server Version 9.0
            c) MySQL
            d) Java 8 or higher
      3) Open the Project in the Eclipse IDE.
      4) Configure Tomcat Server with the IDE.
      5) Make sure that in the "lib" folder of the Tomcat Server there is MySQL connector.jar file. If not then add it.
      6) Create a Database named ConvoCheck in your MySQL Database.
      7) Create a Table within the database named Accounts with fields as EMAIL(Primary Key),UNAME,PASS.
      8) Change the hostname and password in the ConnectionFactory.java file to your own set hostname and password in MySQL.
      9) Run the Application by running the Tomcat Server.

---

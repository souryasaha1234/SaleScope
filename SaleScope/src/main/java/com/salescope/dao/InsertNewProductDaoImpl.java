package com.salescope.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.salescope.factory.ConnectionFactory;

public class InsertNewProductDaoImpl implements InsertNewProductDao {

    private static String generateRandomNumber() {
        // Creating an instance of the Random class
        Random random = new Random();

        // Generating a random number between 1 and 999
        int randomNumber = random.nextInt(999) + 1;

        // Formatting the random number to always have 3 digits by left-padding with zeros
        String formattedRandomNum = String.format("%03d", randomNumber);

        return formattedRandomNum;
    }

	
	@Override
	public String insertNewProduct(String pdtName, String uname) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String status = null;
		String query1 = null, query2 = null, query3 = null, query4 = null;
		
		try {
			con = ConnectionFactory.getUserDBConnectionObject(uname);

			if(con != null)
				st = con.createStatement();
			
			if(st!=null) {
				//checking if product table already exists or not
				query1 = "SHOW TABLES";
				rs = st.executeQuery(query1);
				
				boolean flag = false;
				while (rs.next() != false) {
					if (rs.getString(1).equalsIgnoreCase("products"))
						flag = true;
				}
				if(flag == false) { // if not present
					// making product table
					query2 = "CREATE TABLE PRODUCTS(PDT_ID VARCHAR(4) PRIMARY KEY, PDT_NAME VARCHAR(20))";
					int count_check = st.executeUpdate(query2);
					if(count_check == 1)
						System.out.println("Product table created successfully!!");
				}
				
				//inserting new product to the product table
				boolean flag1;
				//checking if id already exists
				String formattedRandomNum = "";
				do {
					//generating id 
					formattedRandomNum = generateRandomNumber();
					//System.out.println("Random Number: " + formattedRandomNum);
					
					query3 = "SELECT PDT_ID FROM PRODUCTS WHERE PDT_ID = "+formattedRandomNum;
					rs = st.executeQuery(query3);
					
					flag1 = false;
					while (rs.next() != false) {
						if (rs.getString(1) != null)
							flag1 = true;
					}
					System.out.println("Product added successfully");
				} while (flag1 == true);
				
				
				// INSERT INTO PRODUCTS VALUES ('102', 'EyeDrop');
				query4 = "INSERT INTO PRODUCTS VALUES ('"+formattedRandomNum+"', '"+pdtName+"')";
				int count = st.executeUpdate(query4);
				
				if(count == 1)
					status = "success";
				else
					status = "failed";
			}
			
		} catch (SQLException se) {
			if(se.getErrorCode() == 1)
				System.out.println("Duplicate cannot be inserted to primary key column");			
			if(se.getErrorCode() == 1400)
				System.out.println("Null cannot be inserted to primary key column");
			if(se.getErrorCode() >= 900 && se.getErrorCode()<=999)
				System.out.println("Invalid column name or table name or SQL keywords");			
			if(se.getErrorCode() == 12899)
				System.out.println("Do not insert more than column size data to column");
			System.out.println(se);
			status = "error";
		}
		finally {
			try {
				if(st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return status;
	}

}

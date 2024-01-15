package com.salescope.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.salescope.bean.Product;
import com.salescope.factory.ConnectionFactory;

public class InsertProductSalesDaoImpl implements InsertProductSalesDao {

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
	public String insertProductSales(Product pdt, String uname) {
		// Resource declaration
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String status = "";
		String query = "";
		String query1 = "";
		
		try {
			con = ConnectionFactory.getUserDBConnectionObject(uname);
			if(con != null)
				st = con.createStatement();
			if(st != null) {
				// Creation of a particular product table
				String pdtSelect = pdt.getPdtSelect();
				String costPrice = pdt.getCostPrice();
				String sellPrice = pdt.getSellPrice();
				String purchaseQty = pdt.getPurchaseQty();
				String sellQty = pdt.getSellQty();
				String purchaseDate = pdt.getPurchaseDate();
				String sellDate = pdt.getSellDate();

				int totalPurchase = Integer.parseInt(costPrice) * Integer.parseInt(purchaseQty);
				int totalSale = Integer.parseInt(sellPrice) * Integer.parseInt(sellPrice);
				int netProfit = totalSale - totalPurchase;

				boolean flag1;
				//checking if sales already exists
				String formattedRandomNum = "";
				do {
					//generating id 
					formattedRandomNum = generateRandomNumber();
					//System.out.println("Random Number: " + formattedRandomNum);
					
					query1 = "SELECT SALESID FROM PDT_"+pdtSelect+" WHERE SALESID = "+formattedRandomNum;
					rs = st.executeQuery(query1);
					
					flag1 = false;
					while (rs.next() != false) {
						if (rs.getString(1) != null)
							flag1 = true;
					}
				} while (flag1 == true);
				
				// INSERT INTO 103-DBMS VALUES ('1', 'EyeDrop');
				query = "INSERT INTO PDT_"+pdtSelect+" VALUES('"+formattedRandomNum+"','"+costPrice+"', '"+sellPrice+"', '"+purchaseQty+"', '"+sellQty+"', '"+totalPurchase+"', '"+totalSale+"', '"+netProfit+"', '"+purchaseDate+"', '"+sellDate+"')";
				System.out.println(query);
				int count = st.executeUpdate(query);
				
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
			se.printStackTrace();
			status = "error";
		} finally {
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
			try {
				if(con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
//		System.out.println("===========================================");
//		System.out.println(pdtSelect);
//		System.out.println(costPrice);
//		System.out.println(sellPrice);
//		System.out.println(purchaseQty);
//		System.out.println(sellQty);
//		System.out.println(purchaseDate);
//		System.out.println(sellDate);
//		System.out.println("===========================================");
		
		return status;
	}

}

package com.salescope.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.salescope.bean.ProductList;
import com.salescope.factory.ConnectionFactory;

public class GetProductListDaoImpl implements GetProductListDao {

	@Override
	public ProductList[] getProductList(String uname) {
		ProductList temp_pdtlt[] = new ProductList[100];
		ProductList pdtlt[] = null;
		ProductList product = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		
		try {
			con = ConnectionFactory.getUserDBConnectionObject(uname);

			if(con != null)
				st = con.createStatement();
			
			if(st!=null) {
				query = "SELECT * FROM PRODUCTS";
				rs = st.executeQuery(query);
				
				int i=0;
				while (rs.next() != false) {
					product = new ProductList();
					product.setPdtId(rs.getString("PDT_ID"));
					product.setPdtName(rs.getString("PDT_NAME"));
					temp_pdtlt[i] = product;
					i++;
				}
				pdtlt= new ProductList[i];
				for (int j = 0; j < i; j++) {
					pdtlt[j] = temp_pdtlt[j];
				}
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
			System.out.println("Some error occoured to get product list");
			System.out.println(se);
			se.printStackTrace();
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
			try {
				if(con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return pdtlt;
	}

}
